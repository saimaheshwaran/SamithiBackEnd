package com.sai.samithi.exception;

import java.util.Map;

public record ErrorResponse(Map<SamithiApiError, String> errors) {

	public ErrorResponse(SamithiApiError error) {
		this(Map.of(error, error.getMessage()));
	}
	
}
