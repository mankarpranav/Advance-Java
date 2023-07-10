package com.app.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDTO {
    private String msg; // Represents the response message
    private LocalDateTime dt; // Represents the date and time of the response

    public ResponseDTO(String msg) {
        this.msg = msg;
        this.dt = LocalDateTime.now();
    }
}
