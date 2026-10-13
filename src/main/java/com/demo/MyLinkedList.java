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
		if (isEmpty()) {
			throw new LinkedListEmptyException();
		} else {
			E data = head.data;
			head = head.next;
			return data;
		}
	}

	public E removeLast() {
		if (isEmpty()) {
			throw new LinkedListEmptyException();
		} else if (head.next == null) {
			return removeFirst();
		} else {
			Node<E> temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}

			E data = temp.next.data;
			temp.next = null;
			return data;
		}
	}

	public E remove(int index) {
		int size = size();
		if (index >= 0 && index < size) {
			if (index == 0) {
				return removeFirst();
			} else if (index == size - 1) {
				return removeLast();
			} else {
				Node<E> temp = head;
				int count = 0;
				while (count < index - 1) {// 0<1
					count++;
					temp = temp.next;
				}
				E data = temp.next.data;
				temp.next = temp.next.next;
				return data;
			}
		} else {
			throw new IndexOutOfBoundsException("index should be in >=0 & <" + size);
		}
	}

	public E peekFirst() {
		if (isEmpty()) {
			throw new LinkedListEmptyException();
		} else {
			return head.data;
		}
	}

	public E peekLast() {
		if (isEmpty()) {
			throw new LinkedListEmptyException();
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			return temp.data;
		}
	}

	public int search(E element) {
		if (isEmpty()) {
			throw new LinkedListEmptyException();
		} else {
			int index = 0;
			/*
			 * Node<E> temp = head; while (temp!= null) { if(temp.data==element) { return
			 * index; } index++; temp=temp.next; }
			 */
			
			for(Node<E> temp=head;temp!=null;temp=temp.next) {
				if(temp.data==element) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}

}
