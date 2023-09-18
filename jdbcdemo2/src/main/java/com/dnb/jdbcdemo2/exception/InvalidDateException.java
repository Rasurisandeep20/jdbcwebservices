package com.dnb.jdbcdemo2.exception;

public class InvalidDateException extends Exception {
	public InvalidDateException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
}
