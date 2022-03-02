package com.vivek.java;

public class TestInterface8 implements firstInterface, secondInteface {

	public static void main(String args [] ) {
		System.out.println("Main Method!");
		TestInterface8 obj = new TestInterface8();
		obj.show();
		obj.check();
		firstInterface.staticMethod();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		firstInterface.super.show();
		secondInteface.super.show();
	}
	
	public void check() {
		firstInterface.super.show();
		secondInteface.super.show();
	}
}

interface firstInterface {
	
	public default void show() {
		System.out.println("Show from first");
	}
	
	public static void staticMethod() {
		System.out.println("Static method from first Interface");
	}
}

interface secondInteface {
	public default void show() {
		System.out.println("Show from second");
	}
}
