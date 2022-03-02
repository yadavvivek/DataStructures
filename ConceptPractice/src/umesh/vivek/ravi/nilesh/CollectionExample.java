package umesh.vivek.ravi.nilesh;

import java.util.*;
import java.util.function.Consumer;

public class CollectionExample {
	
	public static void main(String args []) {
		
		ConsumerType<Integer> consumer = new ConsumerType<>();
		
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		
		
		arrayList.forEach(CollectionExample::method);
		
		/*
		 * for(Integer x: arrayList) { System.out.println(x); }
		 */
	}
	
	public static void method(Integer x) {
		System.out.println("x-> "+x);
	}
}


class ConsumerType<Integer> implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}
}
