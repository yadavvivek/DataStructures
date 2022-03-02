package com.vivek.java;

//Parent ke reference aur object child ka: dot method() par - "child method" print hoga  --- overriding of normal method
//Parent ke reference aur object child ka: dot staticMethod() par - "child static method" print hona chahie --- overriding of static method : vaise to wrong hoga
// actual me "Parent static method" print hoga chahie because static me overriding support nhi hota hai

class Parent {
	public void method() {
		System.out.println("Parent method!");
	}
	
	public static void staticMethod() {
		System.out.println("Parent static method!");
	}
}

class Child extends Parent {
	public void method() {
		System.out.println("Child method!");
	}
	
	public static void staticMethod() {
		System.out.println("child static method!");
	}
	
}

public class StaticOverrideTest {

	@SuppressWarnings("static-access")
	public static void main(String args []) {
		Parent obj = new Child();
		
		obj.method();
		obj.staticMethod();
	}
}
