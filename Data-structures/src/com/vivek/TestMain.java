package com.vivek;

class TestA {
	protected String name = "Vivek";
	 protected void methodPrectect() {
		System.out.println("Protected method called!");
	}
}

class TestB extends TestA {
	
}

class TestC extends TestB {
	
}

public class TestMain{
	public static void main(String args []) {
		TestB b = new TestB();
		TestC c = new TestC();
		b.methodPrectect();
		c.methodPrectect();
		System.out.println("Name: "+c.name);
		
		for(int i = 0; i < 1; i++, c.methodPrectect()) {
			System.out.println("1 i = "+i);
		}
	}
}
