package com.dnb.jdbcdemo2.exception;

public class InvalidNameException  extends Exception{
	public InvalidNameException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
	}


