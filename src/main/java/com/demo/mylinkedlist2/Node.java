package com.demo.mylinkedlist2;

public class Node<E> {
	public E data;
	public Node<E> next;
	
	private Node() {

	}

	public Node(E data) {
		this.data = data;
		this.next=null;
	}
}
