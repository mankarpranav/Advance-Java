package com.app.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDTO {
	private String msg;
	private LocalDateTime dt;

	public ResponseDTO(String msg) {
		this.msg = msg;
		this.dt = LocalDateTime.now();
	}
}
