package com.dnb.jdbcdemo2.advice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dnb.jdbcdemo2.exception.IdNotFoundException;

@ControllerAdvice
public class AppAdvice {
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="invalid id provided")
	@ExceptionHandler(IdNotFoundException.class)
public void invalidAccoundIdExceptionHandler(IdNotFoundException e) {
//		Map<String,String> map=new HashMap<>();
//  map.put("message", e.getMessage());
// map.put("Httpstatus",HttpStatus.NOT_FOUND+"");
//    return new ResponseEntity(map,HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String, String>> handleException(HttpRequestMethodNotSupportedException e) throws IOException{
		String provided=e.getMethod();
		List<String> supported=List.of(e.getSupportedMethods());
		String error=provided+"is not of the supposrted Http Methods("+String.join(",", supported)+")";
		Map<String, String> errorResponse = Map.of(
				"error",error,
				"message",e.getLocalizedMessage(),
				"status", HttpStatus.METHOD_NOT_ALLOWED.toString()
				);
		return new ResponseEntity<>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);
	}
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, HttpRequest request) {
//		
//		Map<String,Object> responseBody=new LinkedHashMap<>();
//		responseBody.put("timestamp", LocalDateTime.now());
//		responseBody.put("status", status.value());
//		
//		
////	List<String> errors=ex.getBindingResult().getFieldErrors().stream()
////				.map(x->x.getDefaultMessage())
////				.collect(Collectors.toList());
////		responseBody.put("errors", errors);
//		
//			Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream().collect(
//		            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//			responseBody.put("errors", errors);
//		
//		
//		return new ResponseEntity<>(responseBody,headers,status);
//		
//	}

	
	
	
}
