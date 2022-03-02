package com.vivek.ds.graph;

import java.util.*;

public class DFSAlgoImpl {
	
	private boolean[] visited; 
	private int n;
	private List<List<Integer>> graph;
	
	public DFSAlgoImpl(List<List<Integer>> graph) {
		n = graph.size();
		visited = new boolean[n];
		this.graph = graph;
		for(int i = 0; i < n; i++) {
			visited[i] = false;
		}
	}
	
	public static void main(String args [] ) {
	//index of list is node and values in the index node are adjacent neighbors
	List<List<Integer>> graph = new ArrayList<List<Integer>>();
	
	List<Integer> nbr0 = new ArrayList<>();
	nbr0.add(1);
	nbr0.add(9);
	graph.add(new ArrayList<>(nbr0));
	
	List<Integer> nbr1 = new ArrayList<>();
	nbr1.add(0);
	nbr1.add(8);
	graph.add(new ArrayList<>(nbr1));
	
	List<Integer> nbr2 = new ArrayList<>();
	nbr2.add(3);
	graph.add(new ArrayList<>(nbr2));
	
	List<Integer> nbr3 = new ArrayList<>();
	nbr3.add(2);
	nbr3.add(4);
	nbr3.add(5);
	nbr3.add(7);
	graph.add(new ArrayList<>(nbr3));
	
	List<Integer> nbr4 = new ArrayList<>();
	nbr4.add(3);
	graph.add(new ArrayList<>(nbr4));
	
	
	List<Integer> nbr5 = new ArrayList<>();
	nbr5.add(3);
	nbr5.add(6);
	graph.add(new ArrayList<>(nbr5));
	
	List<Integer> nbr6 = new ArrayList<>();
	nbr6.add(5);
	nbr6.add(7);
	graph.add(new ArrayList<>(nbr6));
	
	List<Integer> nbr7 = new ArrayList<>();
	nbr7.add(3);
	nbr7.add(6);
	nbr7.add(8);
	nbr7.add(11);
	nbr7.add(10);
	graph.add(new ArrayList<>(nbr7));
	
	List<Integer> nbr8 = new ArrayList<>();
	nbr8.add(7);
	nbr8.add(9);
	graph.add(new ArrayList<>(nbr8));
	
	List<Integer> nbr9 = new ArrayList<>();
	nbr9.add(0);
	nbr9.add(8);
	graph.add(new ArrayList<>(nbr9));
	
	List<Integer> nbr10 = new ArrayList<>();
	nbr10.add(7);
	nbr10.add(11);
	graph.add(new ArrayList<>(nbr10));
	
	List<Integer> nbr11 = new ArrayList<>();
	nbr11.add(7);
	nbr11.add(10);
	graph.add(nbr11);
	
	List<Integer> nbr12 = new ArrayList<>();
	graph.add(new ArrayList<>(nbr12));

	DFSAlgoImpl d = new DFSAlgoImpl(graph);
	
	List<Integer> unVis = d.findUnVisitedNode();
	System.out.print("UnVisited nodes: ");
	for(int a : unVis) {
		System.out.print(a+", "); 
	}
	System.out.println();
	System.out.println();
	System.out.println("           ***              ");
	d.dfs(0);
	System.out.println("           ***              ");
	System.out.println();
	System.out.println();
	List<Integer> unVis2 = d.findUnVisitedNode();
	System.out.print("UnVisited nodes: ");
	for(int a : unVis2) {
		System.out.print(a+", "); 
	}
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
	
	public List<Integer> findUnVisitedNode() {
		List<Integer> unVisitedNodes = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				unVisitedNodes.add(i);
			}
		}
		
		return unVisitedNodes;
	}
	
}
