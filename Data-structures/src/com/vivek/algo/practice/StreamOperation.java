package com.vivek.algo.practice;

import java.util.*;
import java.util.function.Consumer;

public class StreamOperation {
	
	public static void main(String args []) {
		List<Integer> listString = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			listString.add(i);
		}
		
		System.out.println("Stream: ");
		listString.stream().filter(n -> n > 2).forEach(System.out::println);
	}
}


