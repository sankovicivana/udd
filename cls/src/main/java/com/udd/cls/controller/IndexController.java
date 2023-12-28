package com.udd.cls.controller;

import io.minio.MinioClient;
import io.minio.ListObjectsArgs;
import io.minio.Result;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.udd.cls.configuration.MinioConfig;

@RequiredArgsConstructor
@RestController
public class IndexController {

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioClient minioClient;

	@PostMapping("/api/index")
	public String index() {

        // MinioClient minioClient = (new MinioConfig()).minioClient();

        Iterable<Result<Item>> objects = minioClient.listObjects(
            ListObjectsArgs.builder()
            .bucket(bucket)
            .build()
        );

        for (Result<Item> object : objects) {
            try {

                String filename = object.get().objectName();

                // Get Object


                // Parse Object


                // Push to Index


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // System.out.println(items);

		return "";
	}

}