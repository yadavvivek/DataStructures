package com.vivek.practice;

import java.util.HashMap;
import java.util.Map;

public class UnionFindPrac1Test {
	
	UnionFindPra1 uf;
	Map<String, Integer> map;
	String[] members =  {"TD", "Nirmala", "Rita", "Guddu", "Priti", "Sheru", "Ballu", "Tinku"};
	
	public UnionFindPrac1Test() {
		map = new HashMap<>();
		
		for(int i = 0; i < members.length; i++) {
			map.put(members[i], i);
		}
		
		uf = new UnionFindPra1(members.length);
	}
	
	public static void main(String args []) {
		
		UnionFindPrac1Test uft = new UnionFindPrac1Test();
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		uft.makeFamilyMember("TD", "Nirmala");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Nirmala : "+uft.getParentMember("Nirmala"));
		System.out.println("Is TD and Nirmala in a same family : "+(uft.isFamilyMember("TD", "Nirmala")? "Ha":"Nahi"));
		System.out.println("Is TD and Rita in a same family : "+(uft.isFamilyMember("TD", "Rita") ? "Ha" : "Nahi"));
		System.out.println("Members for TD : "+uft.getNumberOfMemberForMember("TD"));
		System.out.println("Members for Nirmala : "+uft.getNumberOfMemberForMember("Nirmala"));
		
		System.out.println();
		System.out.println("::: Making members of Guddu and Tinku :::");
		System.out.println();
		
		uft.makeFamilyMember("Guddu", "Tinku");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Tinku : "+uft.getParentMember("Tinku"));
		System.out.println("Is Guddu and Tinku in a same family : "+(uft.isFamilyMember("Guddu", "Tinku")? "Ha":"Nahi"));
		System.out.println("Is TD and Guddu in a same family : "+(uft.isFamilyMember("TD", "Guddu") ? "Ha" : "Nahi"));
		System.out.println("Total Members for Tinku : "+uft.getNumberOfMemberForMember("Tinku"));
		System.out.println("Total Members for Guddu : "+uft.getNumberOfMemberForMember("Guddu"));
		
		System.out.println();
		System.out.println("::: Making same members to Sheru and Ballu :::");
		System.out.println();
		
		uft.makeFamilyMember("Sheru", "Ballu");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Ballu : "+uft.getParentMember("Ballu"));
		System.out.println("Is Sheru and Ballu in a same family : "+(uft.isFamilyMember("Sheru", "Ballu")? "Ha":"Nahi"));
		System.out.println("Is Sheru and Guddu in a same family : "+(uft.isFamilyMember("Sheru", "Guddu") ? "Ha" : "Nahi"));
		System.out.println("Total Members for Sheru : "+uft.getNumberOfMemberForMember("Sheru"));
		System.out.println("Total Members for Ballu : "+uft.getNumberOfMemberForMember("Ballu"));
		
		System.out.println();
		System.out.println("::: Making same members to Rita and Priti :::");
		System.out.println();
		
		uft.makeFamilyMember("Rita", "Priti");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Priti : "+uft.getParentMember("Priti"));
		System.out.println("Is Rita and Priti in a same family : "+(uft.isFamilyMember("Rita", "Priti")? "Ha":"Nahi"));
		System.out.println("Is Sheru and Priti in a same family : "+(uft.isFamilyMember("Sheru", "Priti") ? "Ha" : "Nahi"));
		System.out.println("Total Members for Rita : "+uft.getNumberOfMemberForMember("Rita"));
		System.out.println("Total Members for Priti : "+uft.getNumberOfMemberForMember("Priti"));
		
		System.out.println();
		System.out.println("::: Making same members to TD and Guddu :::");
		System.out.println();
		
		uft.makeFamilyMember("TD", "Guddu");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Guddu : "+uft.getParentMember("Guddu"));
		System.out.println("Is TD and Guddu in a same family : "+(uft.isFamilyMember("TD", "Guddu")? "Ha":"Nahi"));
		System.out.println("Is TD and Priti in a same family : "+(uft.isFamilyMember("TD", "Priti") ? "Ha" : "Nahi"));
		System.out.println("Is Guddu and Nirmala in a same family : "+(uft.isFamilyMember("Guddu", "Nirmala") ? "Ha" : "Nahi"));
		System.out.println("Total Members for TD : "+uft.getNumberOfMemberForMember("TD"));
		System.out.println("Total Members for Tinku : "+uft.getNumberOfMemberForMember("Tinku"));
		
		System.out.println();
		System.out.println("::: Making all members to TD family:::");
		System.out.println();
		
		uft.makeFamilyMember("Sheru", "Tinku");
		uft.makeFamilyMember("Sheru", "Rita");
		System.out.println("Comp size : "+uft.getTotalComponentSize());
		System.out.println("Parent Member of Guddu : "+uft.getParentMember("Guddu"));
		System.out.println("Is TD and Guddu in a same family : "+(uft.isFamilyMember("TD", "Guddu")? "Ha":"Nahi"));
		System.out.println("Is TD and Priti in a same family : "+(uft.isFamilyMember("TD", "Priti") ? "Ha" : "Nahi"));
		System.out.println("Is Guddu and Nirmala in a same family : "+(uft.isFamilyMember("Guddu", "Nirmala") ? "Ha" : "Nahi"));
		System.out.println("Total Members for TD : "+uft.getNumberOfMemberForMember("TD"));
		System.out.println("Total Members for Tinku : "+uft.getNumberOfMemberForMember("Tinku"));
		
	}
	
	private void makeFamilyMember(String a, String b) {
		uf.unify(map.get(a), map.get(b));
	}
	
	private String getParentMember(String member) {
		int mappedInt = uf.find(map.get(member));
		return members[mappedInt];
	}
	
	private int getTotalComponentSize() {
		return uf.componentSize();
	}
	
	private int getNumberOfMemberForMember(String member) {
		return uf.componentSizeOfGroup(map.get(member));
	}
	
	private boolean isFamilyMember(String member1, String member2) {
		return uf.isConnected(map.get(member1), map.get(member2));
	}

}
