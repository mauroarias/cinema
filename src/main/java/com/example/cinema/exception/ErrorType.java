package com.example.cinema.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
	UNKNOWN_ERROR(0),
	NOT_FOUND(1);

	final int errorNumber;

	ErrorType(final int errorNumber) {
		this.errorNumber = errorNumber;
	}
}