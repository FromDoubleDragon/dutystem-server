package com.cowork.dutystem.http.response;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 에러 Response를 반환하는 객체
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private int code;
    private String message;
    private List<String> errorDetails;
    private String responseTime;

    public ExceptionResponse(int code, String message, List<String> errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

}
