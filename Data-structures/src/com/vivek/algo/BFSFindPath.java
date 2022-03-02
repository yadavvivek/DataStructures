package com.vivek.algo;

import java.util.*;

public class BFSFindPath {
	
	private boolean[] visited;
	private Integer[] path;
	private List<List<Integer>> graph;
	
	public BFSFindPath() {
		graph = new ArrayList<>();
		
		List<Integer> nbr0 = new ArrayList<>();
		nbr0.add(7);
		nbr0.add(9);
		nbr0.add(11);
		graph.add(new ArrayList<>(nbr0));
		
		List<Integer> nbr1 = new ArrayList<>();
		nbr1.add(10);
		nbr1.add(8);
		graph.add(new ArrayList<>(nbr1));
		
		List<Integer> nbr2 = new ArrayList<>();
		nbr2.add(3);
		nbr2.add(12);
		graph.add(new ArrayList<>(nbr2));
		
		List<Integer> nbr3 = new ArrayList<>();
		nbr3.add(2);
		nbr3.add(4);
		nbr3.add(7);
		graph.add(new ArrayList<>(nbr3));
		
		List<Integer> nbr4 = new ArrayList<>();
		nbr4.add(3);
		graph.add(new ArrayList<>(nbr4));
		
		
		List<Integer> nbr5 = new ArrayList<>();
		nbr5.add(6);
		graph.add(new ArrayList<>(nbr5));
		
		List<Integer> nbr6 = new ArrayList<>();
		nbr6.add(5);
		nbr6.add(7);
		graph.add(new ArrayList<>(nbr6));
		
		List<Integer> nbr7 = new ArrayList<>();
		nbr7.add(3);
		nbr7.add(6);
		nbr7.add(0);
		nbr7.add(11);
		graph.add(new ArrayList<>(nbr7));
		
		List<Integer> nbr8 = new ArrayList<>();
		nbr8.add(1);
		nbr8.add(9);
		nbr8.add(12);
		graph.add(new ArrayList<>(nbr8));
		
		List<Integer> nbr9 = new ArrayList<>();
		nbr9.add(0);
		nbr9.add(8);
		nbr9.add(10);
		graph.add(new ArrayList<>(nbr9));
		
		List<Integer> nbr10 = new ArrayList<>();
		nbr10.add(1);
		nbr10.add(9);
		graph.add(new ArrayList<>(nbr10));
		
		List<Integer> nbr11 = new ArrayList<>();
		nbr11.add(7);
		nbr11.add(0);
		graph.add(nbr11);
		
		List<Integer> nbr12 = new ArrayList<>();
		nbr12.add(8);
		nbr12.add(2);
		graph.add(new ArrayList<>(nbr12));
		
		visited = new boolean[graph.size()];
		path =  new Integer[graph.size()];
	}
	
	public List<Integer> bfs(int s, int e) {
		path = solve(s);
		return reconstructPath(s, e, path);
	}
	
	private Integer[] solve(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.remove();
			List<Integer> neighbours = graph.get(node);
			for(int next: neighbours) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					path[next] = node;
				}
			}
		}
		
		return path;
	}
	
	private List<Integer> reconstructPath(int s, int e, Integer[] path) {
		List<Integer> pathList = new ArrayList<>();
		for(Integer i = e; i != null; i = path[i]) {
			pathList.add(i);
		}
		return pathList;
	}
	
	public static void main(String args []) {
		BFSFindPath bfs = new BFSFindPath();
		List<Integer> p = bfs.bfs(1, 2);
		System.out.println(p);
	} 

}
