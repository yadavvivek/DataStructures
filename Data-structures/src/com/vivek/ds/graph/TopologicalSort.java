package com.vivek.ds.graph;

import java.util.*;

public class TopologicalSort {

	private int N;
	private boolean[] visited;
	private int[] ordering;
	private List<List<Integer>> graph;
	private int orderingIndex;
	
	
	public TopologicalSort(List<List<Integer>> graph) {
		this.graph = graph;
		N = graph.size();
		visited = new boolean[N];
		ordering = new int[N];
		orderingIndex = N-1;
	}
	
	public int[] topoSort() {
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				ArrayList<Integer> list = new ArrayList<>();
				dfs(i, list);
				for(int l : list) {
					ordering[orderingIndex] = l;
					orderingIndex--;
				}
			}
		}
	
		return ordering;
	}
	
	private void dfs(int node, ArrayList<Integer> list) {
		visited[node] = true;
		List<Integer> nodes = graph.get(node);
		
		for(int n : nodes) {
			if(!visited[n]) {
				dfs(n, list);
			}
		}
		
		list.add(node);
	}
	
	public static void main(String args []) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A");
		map.put(1, "B");
		map.put(2, "C");
		map.put(3, "D");
		map.put(4, "E");
		map.put(5, "F");
		map.put(6, "G");
		map.put(7, "H");
		map.put(8, "I");
		map.put(9, "J");
		map.put(10, "K");
		map.put(11, "L");
		map.put(12, "M");
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		List<Integer> node0 = new ArrayList<Integer>();
		node0.add(3);
		graph.add(node0);
		
		List<Integer> node1 = new ArrayList<Integer>();
		node1.add(3);
		graph.add(node1);
		
		List<Integer> node2 = new ArrayList<Integer>();
		node2.add(0);
		node2.add(1);
		graph.add(node2);
		
		List<Integer> node3 = new ArrayList<Integer>();
		node3.add(6);
		node3.add(7);
		graph.add(node3);
		
		List<Integer> node4 = new ArrayList<Integer>();
		node4.add(0);
		node4.add(3);
		node4.add(5);
		graph.add(node4);
		
		List<Integer> node5 = new ArrayList<Integer>();
		node5.add(9);
		node5.add(10);
		graph.add(node5);
		
		List<Integer> node6 = new ArrayList<Integer>();
		node6.add(8);
		graph.add(node6);
		
		List<Integer> node7 = new ArrayList<Integer>();
		node7.add(8);
		node7.add(9);
		graph.add(node7);
		
		List<Integer> node8 = new ArrayList<Integer>();
		node8.add(11);
		graph.add(node8);
		
		List<Integer> node9 = new ArrayList<Integer>();
		node9.add(11);
		node9.add(12);
		graph.add(node9);
		
		List<Integer> node10 = new ArrayList<Integer>();
		node10.add(9);
		graph.add(node10);
		
		
		List<Integer> node11 = new ArrayList<Integer>();
		graph.add(node11);
		
		List<Integer> node12 = new ArrayList<Integer>();
		graph.add(node12);
		
		TopologicalSort tpSort = new TopologicalSort(graph);
		int[] sorted = tpSort.topoSort();
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.print(map.get(sorted[i])+" ");
		}
	}
	
	
	/*private Integer[] singleSourceSortestPath(int start, List<List<Integer>> graph, int[] toposort) {
		int n = graph.size();
		int i = n-1;
		
		Integer[] distance = new Integer[n];
		distance[start] = 0;
		
		for(int j = 0; j < n; j++) {
			int node = toposort[j];
			
			if(distance[node] != null) {
				List<Integer> neighbours = graph.get(node);
				
				for(int nei : neighbours) {
					int dis = distance[node] + edgeWeight;
					if(distance[nei] == null) {
						distance[nei] = dis;
					} else {
						distance[nei] = Math.min(dis, distance[nei]);
					}
				}
			}
		}
		
		return distance;
	}*/
 	
}
