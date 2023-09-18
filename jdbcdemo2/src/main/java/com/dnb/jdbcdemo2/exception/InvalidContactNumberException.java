package com.dnb.jdbcdemo2.exception;

public class InvalidContactNumberException  extends Exception{
	public InvalidContactNumberException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
}
