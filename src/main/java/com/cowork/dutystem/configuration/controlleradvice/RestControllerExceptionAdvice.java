package com.cowork.dutystem.configuration.controlleradvice;

import com.cowork.dutystem.http.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestControllerExceptionAdvice {

    /**
     * 런타임 에러 -> 서비스 에러 처
     * @param e
     * @param req
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ExceptionResponse handlerRuntimeException(RuntimeException e, HttpServletRequest req) {
        log.error("==================== handlerRuntimeException ====================");
        e.printStackTrace();
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
    }

    /**
     * 메소드 파라미터 valid 불통
     * @param e
     * @param req
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req) {
        log.error("===================== Handler MethodArgumentNotValidException =====================");
        e.printStackTrace();
        return getExceptionResponseFromBindingResult(e.getBindingResult(), HttpStatus.BAD_REQUEST, "유효하지 않은 값이 있습니다.");
    }
    /**
     * Http 요청을 잘못하면 발생. GET인데 POST로 콜한다거나.
     * @param e
     * @param req
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ExceptionResponse handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest req) {
        log.error("===================== Handler HttpRequestMethodNotSupportedException =====================");
        e.printStackTrace();
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), Arrays.asList(e.getMessage()));
    }

    private ExceptionResponse getExceptionResponseFromBindingResult(BindingResult bindingResult, HttpStatus status, String defaultMessage) {
        List<String> errorDetails = Optional.ofNullable(bindingResult.getAllErrors()).orElse(Collections.emptyList())
                .stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
        return new ExceptionResponse(status.value(), errorDetails.isEmpty() ? defaultMessage : errorDetails.get(0), errorDetails);
    }

}
