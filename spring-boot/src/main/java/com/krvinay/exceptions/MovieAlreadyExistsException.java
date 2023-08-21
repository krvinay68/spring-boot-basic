package com.krvinay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class MovieAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String desc;
	
	public MovieAlreadyExistsException(String desc) {
		
		super(String.format("%s", desc));		
		this.desc=desc;
	}

}
