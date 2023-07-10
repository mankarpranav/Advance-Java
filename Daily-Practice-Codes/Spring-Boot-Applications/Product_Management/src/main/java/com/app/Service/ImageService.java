package com.app.Service;

import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.ResponseDTO;

public interface ImageService {
    
    // Interface method to insert an image for a given id
    ResponseDTO insertImage(long id, MultipartFile f);
}
