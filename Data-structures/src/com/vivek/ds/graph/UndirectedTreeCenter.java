package com.vivek.ds.graph;
import java.util.*;

public class UndirectedTreeCenter {
	
	public List<Integer> centerOfUndirectedTree(List<List<Integer>> graph) {
		List<Integer> leaves = new ArrayList<Integer>();
		int n = graph.size();
		
		int[] degree = new int[n];
		
		for(int i = 0; i < n; i++) {
			degree[i] = graph.get(i).size();
			if(degree[i] == 0 || degree[i] == 1) {
				leaves.add(i);
				degree[i] = 0;
			}
		}
		
		int count = leaves.size();
		
		while(count < n) {
			List<Integer> newLeaves = new ArrayList<Integer>();
			for(int leaf : leaves) {
				List<Integer> neighbours = graph.get(leaf); // inside neighbor of leaf ... will be one only
				for(int neighbour : neighbours) {
					degree[neighbour] = degree[neighbour] - 1;
					if(degree[neighbour] == 1) {
						newLeaves.add(neighbour);
						degree[neighbour] = 0;
					}
				}
			}
			count += newLeaves.size();
			leaves = newLeaves;
		}
		
		return leaves;
	}
	
	public static void main(String args []) {
		
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		List<Integer> nbr0 = new ArrayList<>();
		nbr0.add(1);
		nbr0.add(3);
		nbr0.add(4);
		graph.add(new ArrayList<>(nbr0));
		
		List<Integer> nbr1 = new ArrayList<>();
		nbr1.add(2);
		nbr1.add(5);
		nbr1.add(6);
		nbr1.add(0);
		graph.add(nbr1);
		
		List<Integer> nbr2 = new ArrayList<>();
		nbr2.add(1);
		graph.add(nbr2);
		
		List<Integer> nbr3 = new ArrayList<>();
		nbr3.add(0);
		graph.add(nbr3);
		
		List<Integer> nbr4 = new ArrayList<>();
		nbr4.add(0);
		nbr4.add(8);
		nbr4.add(9);
		graph.add(nbr4);
		
		
		List<Integer> nbr5 = new ArrayList<>();
		nbr5.add(1);
		graph.add(nbr5);
		
		List<Integer> nbr6 = new ArrayList<>();
		nbr6.add(1);
		nbr6.add(7);
		graph.add(nbr6);
		
		List<Integer> nbr7 = new ArrayList<>();
		nbr7.add(6);
		graph.add(nbr7);
		
		List<Integer> nbr8 = new ArrayList<>();
		nbr8.add(4);
		graph.add(nbr8);
		
		List<Integer> nbr9 = new ArrayList<>();
		nbr9.add(4);
		graph.add(nbr9);
		
		
		UndirectedTreeCenter utc = new UndirectedTreeCenter();
		for(int center : utc.centerOfUndirectedTree(graph)) {
			System.out.println("center: "+center);
		}
	}

}
