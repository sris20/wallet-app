package com.demo.wallet.payment.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException {

	public static final Log LOG = LogFactory.getLog(CustomException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String string) {
		super(string);
	}

}
