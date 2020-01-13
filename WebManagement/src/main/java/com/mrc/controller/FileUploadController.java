/**
 * 
 */
package com.mrc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jsh
 *
 */

@RestController
@RequestMapping("/files")
@Slf4j
public class FileUploadController {
	@Value("${temp.path}")
	private String tempPath;

	@PostMapping("")
	public List<UploadFiles> upload(@RequestParam String msg, @RequestParam MultipartFile[] files) throws IOException {
		log.info("Upload start : {}", msg);
		List<UploadFiles> list = new ArrayList<UploadFiles>();
		 
		for (MultipartFile file : files) {
			
			String filepath = tempPath + UUID.randomUUID().toString();
			File tmp = new File(filepath);
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), tmp);
			} catch (IOException e) {
				log.error("Error while copying.", e);
				throw e;
			}
			UploadFiles uploadData = new UploadFiles();
			
			uploadData.setFileName(file.getOriginalFilename());
			uploadData.setFileSize(file.getSize());
			uploadData.setFileContentType(file.getContentType());
			uploadData.setAttachmentUrl("http://localhost:8080/files/" + filepath);
		}
		
		
		return list;
	}

	@NoArgsConstructor
	@Data
	private static class UploadFiles {

		private String fileName;

		private long fileSize;

		private String fileContentType;

		private String attachmentUrl;
	}
}
