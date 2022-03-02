package com.vivek.problems;

import java.util.Optional;
import java.util.Scanner;

public class OptionalCheck {

	public static void main(String args []) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter word:");
		String word = s.nextLine();
		System.out.println("changeCase of "+ word + " is : "+ changeCase(word).get());
	}
	
	private static Optional<String> changeCase(String word) {
		if(word != null && word.startsWith("A")) {
			return Optional.of(word.toUpperCase());
		} else {
			return Optional.ofNullable(word);
		}
	}
}
