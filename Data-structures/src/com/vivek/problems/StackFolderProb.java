package com.vivek.problems;

import java.util.Stack;

public class StackFolderProb {

	public static void main(String args []) {
		String path = "/a//b////c/d//././/..";
		
		System.out.println("Canonical Path : "+getCanonicalPath(path));
		
	}
	
	private static String getCanonicalPath(String str) {
		String[] elementArray = str.split("/");
		for(String s : elementArray) {
			System.out.print(","+s);
		}
		Stack<Integer> stac = new Stack<>();
		Stack<String> stack = new Stack<String>();
		for(String element : elementArray) {
			if(element.equals(".")) {
				continue;
			} else if(element.equals("..")) {
				if(stack.isEmpty()) continue;
				stack.pop();
			} else {
				if (element.isEmpty()) continue;
				stack.push(element);
			}
		}
		if(stack.isEmpty()) return "/";
		String canonicalPath = "";
		while(!stack.isEmpty()) {
			canonicalPath = "/"+stack.pop() + canonicalPath;
		}
		return canonicalPath;
	}
}
