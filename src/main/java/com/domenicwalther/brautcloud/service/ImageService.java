package com.domenicwalther.brautcloud.service;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageService {

	@Autowired
	private S3Service s3Service;

	public ResponseEntity<String> uploadFile(MultipartFile file) {
		try {
			File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
			file.transferTo(tempFile);

			s3Service.uploadFile(file.getOriginalFilename(), tempFile);

			return ResponseEntity.ok("File uploaded successfully");
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body("Uploaded failed: " + e.getMessage());
		}
	}

}
