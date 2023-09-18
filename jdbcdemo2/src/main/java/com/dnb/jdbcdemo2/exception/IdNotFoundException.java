package com.dnb.jdbcdemo2.exception;

public class IdNotFoundException extends Exception {
 public IdNotFoundException(String msg)
 {
	 super(msg);
 }
 public String toString() {
	 return super.toString()+super.getMessage();
 }
}
