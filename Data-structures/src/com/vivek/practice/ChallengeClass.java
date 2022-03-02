package com.vivek.practice;

import java.util.HashMap;
import java.util.Map;

public class ChallengeClass {
	
	
	public static void main(String args []) {
		String s = "1020122";
		int k = 2;
		
		int result = getResult(s, k);
		System.out.println("Result: "+result);
	}
	
	private static int getResult(String s, int k) {
		int count = 0;
		Map<Character, Integer> store = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(store.containsKey(c)) {
				int value = store.get(c);
				if(value == 2) {
					break;
				} else {
					store.put(c, value+1);
				}
			} else {
				store.put(c, 1);
			}
			
			
			boolean flag  = true;
			for(int occ : store.values()) {
				if(occ < k) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				count++;
			}
		}
				
		return count;
	}

}
