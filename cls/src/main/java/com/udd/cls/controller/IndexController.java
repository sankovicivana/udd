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
import org.springframework.beans.factory.annotation.Autowired;
import com.udd.cls.service.DocumentService;
import com.udd.cls.service.MinioFileService;
import com.udd.cls.indexmodel.ContractIndex;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import io.minio.GetObjectResponse;

@RequiredArgsConstructor
@RestController
public class IndexController {

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioClient minioClient;

    @Autowired
    DocumentService documentService;

    @Autowired
    MinioFileService minioFileService;

	@PostMapping("/api/index")
	public String index() {

        // MinioClient minioClient = (new MinioConfig()).minioClient();

        Iterable<Result<Item>> objects = minioClient.listObjects(
            ListObjectsArgs.builder()
            .bucket(bucket)
            .build()
        );

        for (Result<Item> object : objects) {
            InputStream inputStream = null;
            try {

                String filename = object.get().objectName();
                System.out.println("Filename " + filename);
                GetObjectResponse response = minioFileService.loadAsResource(filename);
                System.out.println("Filename " + response);
                inputStream = response;
                System.out.println("inputStream " + inputStream);
                // Read the content from the InputStream into a String
                String txt = documentService.getTextFromInputStream(inputStream);
                
                // Process 'txt' as needed
                System.out.println("Text content: " + txt);
                // Get Object


                // Parse Object


                // Push to Index
                ContractIndex contract = new ContractIndex();
                contract.setId(UUID.randomUUID().toString());
                contract.setObjectKey(filename);
                contract.setFirstName("Zagor");
                contract.setLastName("Simski");
                contract.setAddress("Nikole Pasica 77, Beograd");
                contract.setAdministrationLevel("Opstina");
                contract.setContent(txt);
                documentService.createContract(contract);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Make sure to close the InputStream after using it
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // System.out.println(items);

		return "";
	}

}