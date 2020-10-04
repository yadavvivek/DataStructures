package com.vivek.ds;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
	
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	private class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;
		
		public Node(T data, Node<T> next, Node<T> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	//method 1
	public void clear() {
		Node<T> trav = head;
		while(trav != null) {
			Node<T> next = trav.next;
			trav.next = trav.prev = null;
			trav.data = null;
			trav = next;
		}
		head = tail = null;
		size = 0;
	}
	
	//method 2
	public int size() {
		return size;
	}
	
	//method 3
	public boolean isEmpty() {
		return size == 0;
	}
	
	//method 4
	public void add(T elem) {
		addLast(elem);
	}
	
	//method 5
	public void addLast(T elem) {
		if(isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			tail.next = new Node<T>(elem, null, tail);
			tail = tail.next;
		}
		size++;
	}
	
	//method 6
	public void addFirst(T elem) {
		if(isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			head.prev = new Node<T>(elem, head, null);
			head = head.prev;
		}
		size++;
	}
	
	//method 7
	public T peekFirst() {
		if(isEmpty()) throw new RuntimeException("Empty List");
		return head.data;
	}
	
	//method 8
	public T peekLast( ) {
		if(isEmpty()) throw new RuntimeException("Empty List");
		return tail.data;
	}
	
	//method 9
	public T removeFirst() {
		if(isEmpty()) throw new RuntimeException("Empty List");
		
		T data = head.data;
		head = head.next;
		--size;
		if(isEmpty()) tail = null;
		else head.prev = null;
		return data;
	}
	
	//method 10
	public T removeLast() {
		if(isEmpty()) throw new RuntimeException("Empty List");
		
		T data = tail.data;
		tail = tail.prev;
		size--;
		if(isEmpty()) head = null;
		else tail.next = null;
		return data;
	}
	
	//method 11
	public T removeAt(int index) {
	
		if(index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index!");
		
		int i;
		Node<T> trav;
		
		if(index < size/2) {
			for(i = 0, trav = head; i != index; i++)
				trav = trav.next;
		} else {
			for(i = size - 1, trav = tail; i != index; i--)
				trav = trav.prev;
		}
		return remove(trav);
	}
	
	//method 12
	private T remove(Node<T> node) {
		
		if(node.prev == null) return removeFirst();
		if(node.next == null) return removeLast();
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		T data = node.data;
		
		node.data = null;
		node.next = null;
		node.prev = null;
		
		--size;
		
		return data;
	}
	
	//method 13
	public int indexOf(Object obj) {
		
		int index = 0;
		Node<T> trav = head;
		
	    //check for null object 
		if(obj == null) {
			for(; trav != null; trav = trav.next, index++) {
				if(trav.data == null) return index;
			}
		} else {
			for(; trav != null; trav = trav.next, index++) {
				if(obj.equals(trav.data)) return index;
			}
		}
		return -1;
	}
	
	//method 14
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}
	
	//method 15
	//remove a particular value in list
	public boolean remove(Object obj) {
		
		if(indexOf(obj) != -1) {
			removeAt(indexOf(obj));
			return true;
		} else {
			return false;
		}
	}
	
	//method 16
	@Override
	public String toString() {
		if(size == 0) return "{}";
		
		StringBuilder sb = new StringBuilder("{ ");
		Node<T> temp = head;
		while(temp != null) {
			sb.append(temp.data+ " ");
			temp = temp.next;
		}
		return sb.append("}").toString();	
	}
	
	//method 17
	public T getHead() {
		if(size > 0)
			return head.data;
		else 
			return null;
	}
	
	//method 18
	public T getTail() {
		if(size > 0)
			return tail.data;
		else 
			return null;
	}
	
	//method 19
	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T> () {
			
			Node<T> trav = head;
			
			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}
			
			@Override
			public boolean hasNext() {
				return trav != null;
			}
		};
	}
}
