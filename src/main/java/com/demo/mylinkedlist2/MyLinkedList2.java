package com.demo.mylinkedlist2;

import java.util.NoSuchElementException;

public class MyLinkedList2<E> {
	private Node<E> head;
	private Node<E> tail;
	private static int count = 0;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if (!isEmpty()) {
			Node<E> temp = head;
			while (temp != null) {
				sb.append(temp.data);
				sb.append(",");
				temp = temp.next;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

	public void addLast(E data) {
		Node<E> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
	}

	public void insert(int index, E data) {
		int size = size();

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index should be in >= 0 & <= " + size);
		}

		Node<E> newNode = new Node<>(data);

		if (index == 0) {
			newNode.next = head;
			head = newNode;

			if (tail == null) {
				tail = newNode;
			}
		} else if (index == size) {
			tail.next = newNode;
			tail = newNode;
		} else {
			Node<E> temp = head;

			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}

			newNode.next = temp.next;
			temp.next = newNode;
		}

		count++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E data = head.data;
		head = head.next;
		count--;
		if (head == null) {
			tail = null;
		}
		return data;
	}

	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E data = tail.data;

		if (count == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> temp = head;

			while (temp.next != tail) {
				temp = temp.next;
			}

			tail = temp;
			tail.next = null;
		}

		count--;
		return data;
	}

	public E remove(int index) {
		int size = size();

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index should be in >= 0 & < " + size);
		}

		E data;

		if (index == 0) {
			data = head.data;
			head = head.next;

			if (head == null) {
				tail = null;
			}
		} else {
			Node<E> temp = head;

			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}

			data = temp.next.data;

			if (temp.next == tail) {
				tail = temp;
				tail.next = null;
			} else {
				temp.next = temp.next.next;
			}
		}

		count--;
		return data;
	}

	public E peekFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	public E peekLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	public int search(E element) {
		int i = 0;
		for (Node<E> temp = head; temp != null; temp = temp.next) {
			if (java.util.Objects.equals(temp.data, element)) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
