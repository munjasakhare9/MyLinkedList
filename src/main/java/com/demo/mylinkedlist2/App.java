package com.demo.mylinkedlist2;

import java.util.LinkedList;

import com.demo.MyLinkedList;

public class App {
	public static void main(String[] args) {
		MyLinkedList2<Integer> list = new MyLinkedList2<>();
		list.addLast(10);
		list.addLast(30);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println("----------------------------------------");
		System.out.println(list.search(30));
		System.out.println(list);
		System.out.println(list.size());

	}
}
