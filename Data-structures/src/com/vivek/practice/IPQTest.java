package com.vivek.practice;


public class IPQTest {
	
	public static void main(String args []) {
		DArrayPrac1<Integer> dynamicArray = new DArrayPrac1<>(1);
		dynamicArray.add(10);
		dynamicArray.add(20);
		dynamicArray.add(21);
		dynamicArray.add(22);
		dynamicArray.add(23);
		System.out.println(dynamicArray);
		System.out.println("size: "+dynamicArray.size());
	
		System.out.println("deleted: "+dynamicArray.remove(22));
		System.out.println("size: "+dynamicArray.size());
		System.out.println("deleted: "+dynamicArray.removeAt(2));
		System.out.println("size: "+dynamicArray.size());
		System.out.println(dynamicArray);
		
		System.out.println("index of 20: "+dynamicArray.indexOf(20));
		System.out.println("index of 22: "+dynamicArray.indexOf(22));
		System.out.println("size: "+dynamicArray.size());
	}

}
