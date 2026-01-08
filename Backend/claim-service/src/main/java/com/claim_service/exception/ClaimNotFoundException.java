package com.claim_service.exception;

public class ClaimNotFoundException extends RuntimeException{
	public ClaimNotFoundException(String msg) {
		super(msg);
	}
}
