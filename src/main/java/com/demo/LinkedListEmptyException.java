package com.demo;

public class LinkedListEmptyException extends RuntimeException {
	private String msg="LinkedList is empty!!!";
	
	public LinkedListEmptyException() {
		
	}
	
	public LinkedListEmptyException(String msg) {
		this.msg=msg;
	}
}
