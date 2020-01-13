/**
 * 
 */
package com.mrc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/file")
@Slf4j
public class FileUploadController {
	private static final String EXTERNAL_FILE_PATH = "C:/fileDownloadExample/";
    
	@PostMapping("/upload")
	public List<UploadFiles> upload(@RequestParam String dirPath, @RequestParam MultipartFile[] files) throws IOException {
		List<UploadFiles> list = new ArrayList<UploadFiles>();
		 
		for (MultipartFile file : files) {
			
			String filepath = dirPath + UUID.randomUUID().toString();
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
	@RequestMapping("/download/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {

		File file = new File(EXTERNAL_FILE_PATH + fileName);
		if (file.exists()) {

			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				//unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);

			/**
			 * In a regular HTTP response, the Content-Disposition response header is a
			 * header indicating if the content is expected to be displayed inline in the
			 * browser, that is, as a Web page or as part of a Web page, or as an
			 * attachment, that is downloaded and saved locally.
			 * 
			 */

			/**
			 * Here we have mentioned it to show inline
			 */
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			 //Here we have mentioned it to show as attachment
			 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
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
