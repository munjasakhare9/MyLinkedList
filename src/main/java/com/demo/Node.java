package com.demo;

public class Node<E> {
	public E data;
	public Node<E> next;
	
	private Node() {
		
	}
	
	public Node(E element) {
		this.data=element;
		this.next=null;
	}
}
