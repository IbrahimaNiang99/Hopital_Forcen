package com.forcenhopital.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestException extends RuntimeException {
    String message;
    HttpStatus status;

    public RequestException(String message){
        super(message);
    }
}
