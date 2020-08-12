package com.cowork.dutystem.http.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * API 호출 성공시 Response 담을 객체
 * @param <T>
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse<T> {
    private int code;
    private String message;
    private T result;
    private String responseTime;

    public SuccessResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
