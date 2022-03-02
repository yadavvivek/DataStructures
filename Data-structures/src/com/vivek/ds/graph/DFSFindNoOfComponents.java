package com.vivek.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSFindNoOfComponents {
	private boolean[] visited; 
	private int n;
	private List<List<Integer>> graph;
	
	public DFSFindNoOfComponents(List<List<Integer>> graph) {
		n = graph.size();
		visited = new boolean[n];
		this.graph = graph;
		for(int i = 0; i < n; i++) {
			visited[i] = false;
		}
	
	}
	
	
	public static void main(String args []) {
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		List<Integer> nbr0 = new ArrayList<>();
		nbr0.add(1);
		graph.add(new ArrayList<>(nbr0));
		
		List<Integer> nbr1 = new ArrayList<>();
		nbr1.add(0);
		graph.add(new ArrayList<>(nbr1));
		
		List<Integer> nbr2 = new ArrayList<>();
		nbr2.add(2);
		graph.add(new ArrayList<>(nbr2));
		
		List<Integer> nbr3 = new ArrayList<>();
		nbr2.add(3);
		graph.add(new ArrayList<>(nbr3));
		
		DFSFindNoOfComponents dfsComp = new DFSFindNoOfComponents(graph);
		System.out.println(": "+dfsComp.getNoOfComp());
	}
	
	private int getNoOfComp() {
		int count = 0;
		for(int i = 0; i < graph.size(); i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println("=========================");
		System.out.println(count);
		System.out.println("=========================");
		
		return count;
	}
	
	
	
	
	public void dfs(int at) {
		if(visited[at]) {
			System.out.print(at+" backTrack;\n");
			return;
		}
		
		
		if(at == 0) {
			System.out.print("Started at -> "+at);
		} else {
			System.out.print(at+";");
		}
		System.out.println();
		
		
		visited[at] = true;
		List<Integer> neighbours = graph.get(at);
		
		
		System.out.println(at +" nbrs -> "+neighbours);
		
		
		for(int neighbour : neighbours) {
			System.out.print(at+" -> ");
			dfs(neighbour);
		}
	}
}
