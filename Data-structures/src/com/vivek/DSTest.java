package com.vivek;

import com.vivek.ds.DoublyLinkedList;
import com.vivek.ds.DynamicArray;
import com.vivek.practice.DynArrayP1;

public class DSTest {
	
	public static void main(String args []) {
		testDyArray();
//		testDoubLinList();
//		DynamicArray<String> array = new DynamicArray<>();
//		testD(array);
		
	}
	
	private static void testDoubLinList() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		list.add("One");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		list.add("Two");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
		System.out.println("size: "+list.size());
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add("Six");
		System.out.println("List: "+list+", head: "+list.getHead()+", tail: "+list.getTail());
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
	
	private static void testDyArray() {
		DynamicArray<String> array = new DynamicArray<>();
//		DynArrayP1<String> array = new DynArrayP1<>();
		
		System.out.println(" size = "+array.size()+ " capacity = "+array.getCapacity());
		System.out.println(array);
		
		array.add("Vivek");
		array.add("Yadav");
		array.add("Umesh");
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());
		System.out.println();
		
		array.add("Lalu");
		array.add("Ballu");
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());
		
		System.out.println(" contains Om  "+array.contains("om"));
		System.out.println(" contains Ballu  "+array.contains("Ballu"));
		
		array.set(0, "Ravi");
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());
		array.set(4, "Java");
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());
		
		System.out.println("removed: "+array.removeAt(2));
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());

		array.add("TD");
		System.out.println(array+" size = "+array.size()+" capacity = "+array.getCapacity());
		//second array to test i.e. of Integer
//		DynamicArray<Integer> intArray = new DynamicArray<Integer>(2);
		DynArrayP1<Integer> intArray = new DynArrayP1<>(2);
		
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity()); 
		
		intArray.add(2);
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
		intArray.add(100);
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
		intArray.add(320);
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
		intArray.set(2, 500);
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
		intArray.removeAt(2);
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
		intArray.clear();
		System.out.println(intArray+" size = "+intArray.size()+" capacity = "+intArray.getCapacity());
	}
	
	private static void testD(DynamicArray<String> arr) {
		arr.add("My");
		arr.add("Java");
		arr.add("is");
		System.out.println(arr+" size = "+arr.size()+" capacity = "+arr.getCapacity());
		arr.add("Bhaaag", 1);
		System.out.println(arr+" size = "+arr.size()+" capacity = "+arr.getCapacity());
	}
}
