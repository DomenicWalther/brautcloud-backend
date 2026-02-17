package com.domenicwalther.brautcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class ImageController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try {
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            s3Service.uploadFile(file.getOriginalFilename(), tempFile);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e){
            return ResponseEntity.status(500).body("Uploaded failed: " + e.getMessage());
        }
    }
}
