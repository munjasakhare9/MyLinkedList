package com.demo;

public class MyLinkedList<E> {
	private Node<E> head = null;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		int count = 0;
		Node<E> temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

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
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void addFirst(E data) {
		Node<E> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
	}

	public void insert(int index, E data) {
		int size = size();
		if (index >= 0 && index < size) {
			if (index == 0) {
				addFirst(data);
			} else {
				Node<E> newNode = new Node<>(data);
				Node<E> temp = head;
				int count = 0;
				while (count < index - 1) {
					temp = temp.next;
					count++;
				}
				newNode.next = temp.next;
				temp.next = newNode;
			}
		} else {
			throw new IndexOutOfBoundsException("index should be in >=0 & <" + size);
		}
	}

	public E removeFirst() {
		if(isEmpty()) {
			throw new LinkedListEmptyException();
		}
		else {
			E data=head.data;
			head=head.next;
			return data;
		}
	}
	
}
