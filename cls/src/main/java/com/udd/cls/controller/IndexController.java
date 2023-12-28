package com.udd.cls.controller;

import io.minio.MinioClient;
import io.minio.ListObjectsArgs;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.udd.cls.configuration.MinioConfig;

@RestController
public class IndexController {

    @Value("${minio.bucket}")
    private String bucket;

	@PostMapping("/api/index")
	public String index() {

        MinioClient minioClient = (new MinioConfig()).minioClient();

        Iterable<Result<Item>> files = minioClient.listObjects(
            ListObjectsArgs.builder()
            .bucket(bucket)
            .build()
        );

        System.out.println(files);

		return "";
	}

}