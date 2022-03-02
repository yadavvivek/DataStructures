package umesh.vivek.ravi.nilesh;

import java.util.*;
import java.util.stream.*;

public class Test {
	
	public static void main(String args []) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(3);
		list.add(10);
		list.add(13);
		list.add(12);
		list.add(5);
		list.add(19);
		list.add(19);
		
		
		List<Integer> even = list.stream().filter(i -> i%2 ==0).collect(Collectors.toList());
		List<Integer> odd = list.stream().filter(i -> i%2 !=0).collect(Collectors.toList());
		List<Integer> moreThan10 = list.stream().filter(i -> i > 10).collect(Collectors.toList());
		List<Integer> moreThan10AndEven = list.stream().filter(i -> i > 10)
				.filter(i -> i%2 ==0)
				.collect(Collectors.toList());
		List<Integer> moreThan10AndOdd = list.stream().filter(i -> i > 10)
				.filter(i -> i%2 !=0)
				.collect(Collectors.toList());


		
		even.forEach( i -> {
			System.out.print(" "+i);
		});
		System.out.println();
		odd.forEach( i -> {
			System.out.print(" "+i);
		});
		System.out.println();
		moreThan10.forEach( i -> {
			System.out.print(" "+i);
		});
		System.out.println();
		moreThan10AndEven.forEach( i -> {
			System.out.print(" "+i);
		});
		System.out.println();
		moreThan10AndOdd.forEach( i -> {
			System.out.print(" "+i);
		});
		System.out.println("distinct");
		list.stream().distinct().collect(Collectors.toList()).forEach( i -> {
			System.out.print(" "+i);
		});
		
		System.out.println();
		
		
		System.out.println("square of nums");
		list.stream().map( i -> i*i).collect(Collectors.toList()).forEach( i -> {
			System.out.print(" "+i);
		});
		
		System.out.println();
		
		System.out.println();
		
		
		
	    //count odd
		int count = (int) list.stream().filter(i -> i%2 != 0).count();
		System.out.println("Count odd: "+count);
		
		
		
		
		
		
		
		
	}

	

}
