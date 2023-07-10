package com.app.Service;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.ResponseDTO;

@Service
@Transactional
public class ImageserviceImpl implements ImageService {

	@Value("${upload.location}")
	private String folder;
	
	@PostConstruct
	public void myinit()
	{
		File f=new File(folder);
		if(f.exists())
		{
			System.out.println("file present");
		}else
		{
			f.mkdir();
			System.out.println("file created");
		}
	}
	@Override
	public ResponseDTO insertImage(long id, MultipartFile f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
