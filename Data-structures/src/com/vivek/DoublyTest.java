package com.vivek;

import com.vivek.ds.DoublyLinkedList;

public class DoublyTest {
	
	public static void main(String args []) {
				
//		testDoubLinList();
		int i = 10;
		System.out.println(--i); // 9
		System.out.println(i--);  // 9
		System.out.println(i);  //8
	}
	
	private static void testDoubLinList() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		System.out.println("is empty: "+list.isEmpty());
		
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		
		list.add("One");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		System.out.println("is empty: "+list.isEmpty());
		
		list.add("Two");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add("Six");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		System.out.println("................. contains, One: "+list.contains("One"));
		
		list.remove("One");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("+++++++++++ data Three: "+list.removeAt(2));
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("................. contains, One: "+list.contains("One"));
		System.out.println("size: "+list.size());
		
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		
		System.out.println("list2: "+list2+", head: "+list2.getHead()+", tail: "+list2.getTail());
		System.out.println("size: "+list2.size());
		
		list2.add(1);
		System.out.println("list2: "+list2+", head: "+list2.getHead()+", tail: "+list2.getTail());
		System.out.println("size: "+list2.size());
		
		list2.add(2);
		System.out.println("list2: "+list2+", head: "+list2.getHead()+", tail: "+list2.getTail());
		System.out.println("size: "+list2.size());
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		System.out.println("list2: "+list2+", head: "+list2.getHead()+", tail: "+list2.getTail());
		System.out.println("size: "+list2.size());
		
	}

}
