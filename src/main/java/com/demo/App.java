package com.demo;

import java.util.LinkedList;

public class App {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList<>();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		System.out.println(list);
		System.out.println("-----------------------------");
		System.out.println(list.search(30));
		System.out.println(list);
	
	}
}
