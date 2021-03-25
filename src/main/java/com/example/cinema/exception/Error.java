package com.example.cinema.exception;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class Error {

	private String message;
	private ErrorType errorType;
	private String exceptionType;
}
