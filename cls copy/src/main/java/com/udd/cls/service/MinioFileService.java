package com.udd.cls.service;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.http.Method;
import java.util.Collections;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.udd.cls.configuration.MinioConfig;

@RequiredArgsConstructor
@Service
public class MinioFileService  {

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioClient minioClient;

   public String store(MultipartFile file, String serverFilename) {
        if (file.isEmpty()) {
            throw new Error("Failed to store empty file.");
        }
        var originalFilenameTokens =
            Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        var extension = originalFilenameTokens[originalFilenameTokens.length - 1];
   try {
            PutObjectArgs args = PutObjectArgs.builder()
                .bucket(bucket)
                .object(serverFilename + "." + extension)
                .headers(Collections.singletonMap("Content-Disposition",
                    "attachment; filename=\"" + file.getOriginalFilename() + "\""))
                .stream(file.getInputStream(), file.getInputStream().available(), -1)
                .build();
            minioClient.putObject(args);
        } catch (Exception e) {
           throw new Error("Failed to store empty file.");
        }
        return serverFilename + "." + extension;
   }

    public void delete(String serverFilename) {
        try {
            RemoveObjectArgs args = RemoveObjectArgs.builder()
                .bucket(bucket)
                .object(serverFilename)
                .build();
            minioClient.removeObject(args);
        } catch (Exception e) {
            throw new Error("Error while deleting " + serverFilename + " from Minio.");
        }
    }

    public GetObjectResponse loadAsResource(String serverFilename) {
        try {
            // Get signed URL
            var argsDownload = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucket)
                .object(serverFilename)
                .expiry(60 * 5) // in seconds
                .build();
            var downloadUrl = minioClient.getPresignedObjectUrl(argsDownload);
            System.out.println(downloadUrl);

            // Get object response
            var args = GetObjectArgs.builder()
                .bucket(bucket)
                .object(serverFilename)
                .build();
            return minioClient.getObject(args);
        } catch (Exception e) {
            throw new Error("Document " + serverFilename + " does not exist.");
        }
    }
}