package com.nit.userdefinedexceptions;

public class IncorrectTestCaseNumberException extends RuntimeException {
	public IncorrectTestCaseNumberException(String exceptionMsg){
		super(exceptionMsg);
	}
}
