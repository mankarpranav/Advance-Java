package com.app.GobalExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.DTO.ResponseDTO;
import com.app.Exception.ProductException;

@RestControllerAdvice
public class GlobalProductExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> myhandler(MethodArgumentNotValidException m) {
		Map<String, String> collect = m.getFieldErrors().stream()
				.collect(Collectors.toMap(p -> p.getField(), p -> p.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(collect);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<?> myhandler1(ProductException p)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO("error"));
	}

}
