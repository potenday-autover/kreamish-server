package com.potenday.kreamish.common.error;

import com.potenday.kreamish.common.util.ApiUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiUtils.ApiResult<?>> handleGeneralException(Exception e) {
        return new ResponseEntity<>(
            ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiUtils.ApiResult<?>> handleNoSuchElementException(
        NoSuchElementException e
    ) {
        return new ResponseEntity<>(ApiUtils.error(e.getMessage(), HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class,
        MissingServletRequestParameterException.class,
        IllegalArgumentException.class})
    public ResponseEntity<ApiUtils.ApiResult<?>> handleMethodArgumentNotValidException(
        Exception e) {
        return new ResponseEntity<>(ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST),
            HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ApiUtils.ApiResult<?>> handleTypeMismatchException(TypeMismatchException e) {
        return new ResponseEntity<>(ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST),
            HttpStatus.BAD_REQUEST);
    }
}
