package com.potenday.kreamish.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

public class ApiUtils {

  public static <T> ApiResult<T> success(T response) {
    return new ApiResult<>(true, response, null);
  }

  public static ApiResult<?> error(Throwable throwable, HttpStatus status) {
    return new ApiResult<>(false, null, new ApiError(throwable, status));
  }

  public static ApiResult<?> error(String message, HttpStatus status) {
    return new ApiResult<>(false, null, new ApiError(message, status));
  }

  @Getter
  @NoArgsConstructor
  public static class ApiError {

    private String message;
    private int status;

    ApiError(Throwable throwable, HttpStatus status) {
      this(throwable.getMessage(), status);
    }

    ApiError(String message, HttpStatus status) {
      this.message = message;
      this.status = status.value();
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  public static class ApiResult<T> {

    private boolean success;
    private T response;
    private ApiError error;
  }
}