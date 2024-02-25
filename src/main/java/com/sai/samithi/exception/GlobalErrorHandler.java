package com.sai.samithi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {
	
	private static final String UNEXPECTED_ERROR = "Unexpected error !";
	private static final String VALIDATION_ERROR = "Validation error : %s";

	@ResponseBody
	public ResponseEntity<ErrorResponse> handleHttpStatusError(HttpStatusCodeException httpException){
		final ErrorResponse errorResponse = new ErrorResponse(SamithiApiError.UNKNOWN_ERROR);
		log.error(UNEXPECTED_ERROR);
		return new ResponseEntity<ErrorResponse>(errorResponse, httpException.getStatusCode());
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException exception) {
	  final var errorResponse = new ErrorResponse(SamithiApiError.INVALID_REQUEST);
	  logValidationErrors(exception);
	  return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleValidationError(
	    HttpMessageNotReadableException exception
	) {
	  final var errorResponse = new ErrorResponse(SamithiApiError.INVALID_REQUEST);
	  log.warn(VALIDATION_ERROR.formatted(exception.getMessage()), exception);
	  return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleValidationError(
	    MethodArgumentTypeMismatchException exception
	) {
	  final var errorResponse = new ErrorResponse(SamithiApiError.INVALID_REQUEST);
	  log.warn(VALIDATION_ERROR.formatted(exception.getMessage()), exception);
	  return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneric(Exception exception) {
	  final var errorResponse = new ErrorResponse(SamithiApiError.UNKNOWN_ERROR);
	  log.error(UNEXPECTED_ERROR, exception);
	  return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private void logValidationErrors(MethodArgumentNotValidException exception) {
	  exception.getAllErrors().forEach(error -> {
	    final var errorMessage = getValidationErrorMessage(error);
	    log.warn(VALIDATION_ERROR.formatted(errorMessage));
	  });
	}
	
	private String getValidationErrorMessage(ObjectError error) {
	  if (error instanceof FieldError fieldError) {
	    return "%s %s".formatted(fieldError.getField(), error.getDefaultMessage());
	  }
	  return error.getDefaultMessage();
	}

}
