package com.sai.samithi.exception;


import lombok.Getter;

@Getter
public enum SamithiApiError {
	
	INVALID_REQUEST ("Invalid request data."),
	UNKNOWN_ERROR ("An unknown error occurred.");
	
	private final String message;
	
	private SamithiApiError(String message) {
		this.message = message;
	}

}
