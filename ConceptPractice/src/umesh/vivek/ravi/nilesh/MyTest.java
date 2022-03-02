package umesh.vivek.ravi.nilesh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyTest {
	
	public static void main(String args []) {

		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		
		
		 List<Integer> arrays = Arrays.asList(1,2,4,5);

		  int sum = arrays.stream().filter(i-> i%2!=0)
		 .collect(Collectors.toList()).stream()
		 .map(i->i*i).collect(Collectors.summingInt(i->i));
		  System.out.println(sum);
		  
		  
		  int values[] = {6,5,11,4,7};
		  int target = 4;
		  Arrays.sort(values);//4,5,6,7,11
		  
		  List<Integer> res = new ArrayList<>();
		  
		  List<Integer> list = new ArrayList<>();
		  
		  for(int i = 0; i < values.length; i++) {
			  int complement = values[i] + target;
			  if(list.contains(values[i])) {
				  res.add(values[i]);
				  res.add(values[i] - target);
			  } else {
				  list.add(complement);
			  }
		  }
		  System.out.println("Vivek: "+list+", res: "+res);
		  res.forEach(System.out::println);
		  
		  
			String string = "Be not afraid of greatness, some are born great, some achieve greatness, and some have greatness thrust upon them.";
			String[] arrString = string.split(" ");
			
			String maxString = "";
			for(int i = 0; i < arrString.length; i++) {
				//arrString[i].replace(',', '').replace('.', "");
				if(arrString[i].length() % 2 == 0) {
					if(maxString.length() < arrString[i].length()) {
						maxString = arrString[i];
					}
				}
			}
			
			System.out.println("oooooooooooooooooooooooooooooooo");
			System.out.println(getCount(-11111));
			
			
	}
	
	private static int getCount(int num) {
		Set<Integer> set = new HashSet<>();
		while(num > 0) { //123
			int digit = num%10;
			set.add(digit);
			num = num/10;
		}

		return set.size();
	}
	

	
	

}
