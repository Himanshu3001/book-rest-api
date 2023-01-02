package com.example.bootrestbook.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadhelper {
	//public final String UPLOAD_DIR="C:\\Users\\himan\\Documents\\Code With Durgesh\\boot-rest-book\\src\\main\\resources\\static\\images";
	
	public final String UPLOAD_DIR= new ClassPathResource("/static/images/").getFile().getAbsolutePath();
	
	public FileUploadhelper() throws IOException{
		
	}
	
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f=false;
		
		try {
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
