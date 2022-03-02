package umesh.vivek.ravi.nilesh;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsExp {

	public static void main(String args[]) {
		System.out.println("===========1=========");
		IntStream.range(1, 10).forEach(System.out::println);
		System.out.println("===========2=========");

		// skip 5
		IntStream.range(1, 10).skip(5).forEach(System.out::println);

		System.out.println("===========3==========");

		// sum
		System.out.println(IntStream.range(1, 10).sum());

		System.out.println("===========4=========");

		Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);

		System.out.println("===========5=========");

		// Steam from Array, sort, filter and print

		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Shivika", "Sarah" };

		Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);

		System.out.println("===========6=========");

		// 6. average of squares of an int array

		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(i -> i * i).average().ifPresent(System.out::println);

		System.out.println("===========7=========");
		
		// Stream from List, filter and print:
		Arrays.stream(names)
		.map(String::toLowerCase)
		.filter(x -> x.startsWith("a"))
		.forEach(System.out::println);
		
		System.out.println("===========8=========");
		
		
		
		System.out.println("===========9=========");
		System.out.println("===========10=========");
		System.out.println("===========11=========");
		System.out.println("===========12=========");
		System.out.println("===========13=========");

	}
}
