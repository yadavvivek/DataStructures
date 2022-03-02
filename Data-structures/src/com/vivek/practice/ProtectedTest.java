package com.vivek.practice;

public class ProtectedTest {

	protected void getLaptopDetails() {
		System.out.println("Lenovo: T580");
	}
	
	
	public static void main(String args []) {
		A a = new A();
		A a2 = new A();
		
		System.out.println(a.equals(a2));
	}
}

class A {
	
	@Override
	public boolean equals(Object o) {
		return this == o;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}



