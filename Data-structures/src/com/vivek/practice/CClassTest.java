package com.vivek.practice;

public class CClassTest {

	public static void main(String args []) {
		TestReturn tr = new TestReturn();
		System.out.println("Before calling return .....");
		tr.methodABCReturn();
		System.out.println("After calling return .....");
	}
}

class TestReturn {
	
	
	public void methodABCReturn() {
		return;
	}
}