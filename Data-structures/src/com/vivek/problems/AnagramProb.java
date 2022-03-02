package com.vivek.problems;
import java.util.*;

public class AnagramProb {
	
	public static void main(String args []) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		
		System.out.println("Is "+ str1 + " and "+ str2 +" are anagrams ?: "+isAnagrams(str1, str2));
	}

	public static boolean isAnagrams(String s1, String s2) {
		if(s1.length() == s2.length()) {
			return checkAnag(s1, s2);
		}
		
		return false;
	}
	
	public static boolean checkAnag(String s1, String s2) {
		ArrayList<Character> ch1 = new ArrayList<>(s1.length());
		ArrayList<Character> ch2 = new ArrayList<>(s2.length());
		
		for(int i = 0; i < s1.length(); i++) {
			ch1.add(s1.charAt(i));
			ch2.add(s2.charAt(i));
		}
		Collections.sort(ch1);
		Collections.sort(ch2);
		
		for(int i = 0; i < s1.length(); i++) {
			if(ch1.get(i) != ch2.get(i)) {
				return false;
			}
		}
		
		return true;
	}
}
