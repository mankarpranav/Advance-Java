package com.app.Service;

import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.ResponseDTO;

public interface ImageService {

	ResponseDTO insertImage(long id ,MultipartFile f);
}
