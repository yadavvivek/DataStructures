package com.vivek;

import java.util.HashMap;
import java.util.Map;

import com.vivek.ds.UnionFindDS;

public class UnionFindTest {
	
	private static Map<Integer, String> myFamMap;
	private static UnionFindDS ufMyFamily;
	private static UnionFindDS laFamily;
	private static Map<Integer, String> laFamMap;
	
	public static void main(String [] args) {
		
		ufMyFamily = new UnionFindDS(8);
		
		laFamily = new UnionFindDS(7);
		
	    myFamMap = new HashMap<>();
		
	    myFamMap.put(7, "Talukdar");
		myFamMap.put(6, "Nirmala");
		myFamMap.put(5, "Rita");
		myFamMap.put(4, "Umesh");
		myFamMap.put(3, "Priti");
		myFamMap.put(2, "Vivek");
		myFamMap.put(1, "Ravi");
		myFamMap.put(0, "Nilesh");
		
		laFamMap = new HashMap<>();
		
		laFamMap.put(6, "Meva");
		laFamMap.put(5, "Malti");
		laFamMap.put(4, "Rangita");
		laFamMap.put(3, "Manisha");
		laFamMap.put(2, "Umesh");
		laFamMap.put(1, "La1");
		laFamMap.put(0, "La2");
	}

	public static void unify(String name1, String name2) {
//		Integer p = myFamMap.getKey(name1);
	}

}
