package com.vivek;

import com.vivek.ds.StackImp;

public class StackTest {
	
	public static void main(String args [] ) {
		
		StackImp<String> stack = new StackImp<>();
		
		stackTest(stack);
	}

	private static void stackTest(StackImp<String> stack) {
		stack.push("Vivek");
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
		stack.push("Java");
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
		stack.push("Data");
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
		stack.push("Structures");
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
		stack.pop();
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
		stack.pop();
		System.out.println("Stack : "+stack+ ", peek: "+stack.peek()+", size: "+stack.size());
	}
}
