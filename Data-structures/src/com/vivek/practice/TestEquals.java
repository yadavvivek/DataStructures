package com.vivek.practice;

public class TestEquals {
	
	public static void main(String args []) {
		
		Parent p = new Parent();
		Child c = new Child();
		
		p.equals(c);
	}

}


class Parent {
	
	
	@Override
	public boolean equals(Object parent) {
		System.out.println("Supers equals method");
		return false;
	}
}

class Child extends Parent {
	
	public boolean equals(Object obj) {
		System.out.println("childs equals method");
		return false;
	}
	
}
