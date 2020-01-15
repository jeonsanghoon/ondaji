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
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mrc.framework.Global;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jsh
 *
 */

@RestController
@Slf4j
public class FileUploadController {
	private static final String EXTERNAL_FILE_PATH = "C:/source/files/";
    
	@PostMapping("/upload")
	public List<UploadFiles> upload(@RequestParam MultipartFile[] file) throws IOException {
		List<UploadFiles> list = new ArrayList<UploadFiles>();
		String dirPath = "";
		dirPath = Global.DataInfo.isNullEmpty(dirPath) ? "C:\\Source\\files\\"  : dirPath;
		
		for (MultipartFile filedata : file) {
			
			String extention = "." + FilenameUtils.getExtension(filedata.getOriginalFilename());
			
			String filepath = dirPath + UUID.randomUUID().toString() + extention;
			log.debug("extentioin >>>>>>>>> " + extention);
			File tmp = new File(filepath);
			try {
				FileUtils.copyInputStreamToFile(filedata.getInputStream(), tmp);
			} catch (IOException e) {
				log.error("Error while copying.", e);
				throw e;
			}
			UploadFiles uploadData = new UploadFiles();
			
			uploadData.setFileName(filedata.getOriginalFilename());
			uploadData.setFileSize(filedata.getSize());
			uploadData.setFileContentType(filedata.getContentType());
			uploadData.setAttachmentUrl(filepath);
			list.add(uploadData);
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

			//response.setContentType(mimeType);/*이미지 보기로 이동함*/
			response.setContentType("application/unknown");/*무조건 다운로드*/

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
