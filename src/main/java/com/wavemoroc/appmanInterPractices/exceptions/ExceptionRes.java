package com.wavemoroc.appmanInterPractices.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ExceptionRes {
    private Integer statusCode;
    private HttpStatus httpStatus;
    private String timeStamp;
    private String reason;

    public ExceptionRes(HttpStatus httpStatus, String timeStamp, String reason) {
        this.statusCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
        this.reason = reason;
    }
}

