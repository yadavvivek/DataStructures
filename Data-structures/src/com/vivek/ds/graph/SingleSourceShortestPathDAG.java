package com.vivek.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleSourceShortestPathDAG {

	private int N;
	private boolean[] visited;
	private int[] ordering;
	private List<List<Node>> graph;
	private int orderingIndex;
	
	public SingleSourceShortestPathDAG(List<List<Node>> graph) {
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
		List<Node> nodes = graph.get(node);
		
		for(Node n : nodes) {
			if(!visited[n.to]) {
				dfs(n.to, list);
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
		List<List<Node>> graph = new ArrayList<List<Node>>();
		List<Node> node0 = new ArrayList<Node>();
		node0.add(new Node(1, 3));
		node0.add(new Node(2, 6));
		graph.add(node0);
		
		List<Node> node1 = new ArrayList<Node>();
		node1.add(new Node(4, 11));
		node1.add(new Node(3, 4));
		node1.add(new Node(2, 4));
		graph.add(node1);
		
		List<Node> node2 = new ArrayList<Node>();
		node2.add(new Node(3, 8));
		node2.add(new Node(6, 11));
		graph.add(node2);
		
		List<Node> node3 = new ArrayList<Node>();
		node3.add(new Node(4, -4));
		node3.add(new Node(5, 5));
		node3.add(new Node(6, 2));
		graph.add(node3);
		
		List<Node> node4 = new ArrayList<Node>();
		node4.add(new Node(7, 9));
		graph.add(node4);
		
		List<Node> node5 = new ArrayList<Node>();
		node5.add(new Node(7, 1));
		graph.add(node5);
		
		List<Node> node6 = new ArrayList<Node>();
		node6.add(new Node(7, 2));
		graph.add(node6);
		
		List<Node> node7 = new ArrayList<Node>();
		graph.add(node7);
	
		
		SingleSourceShortestPathDAG tpSort = new SingleSourceShortestPathDAG(graph);
		int[] sorted = tpSort.topoSort();
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.print(map.get(sorted[i])+" ");
		}
		int start = 0;
		Integer[] distance = tpSort.singleSourceSortestPath(start, graph, sorted);
		System.out.println();
		System.out.println("Distance from "+map.get(sorted[start])+": ");
		
		for(int i = 0; i < distance.length; i++) {
			System.out.print("["+map.get(sorted[start])+"-> "+map.get(sorted[i])+": "+distance[i]+"] ");
		}
	}
	
	
	private Integer[] singleSourceSortestPath(int start, List<List<Node>> graph, int[] toposort) {
		int n = graph.size();
		
		Integer[] distance = new Integer[n];
		distance[start] = 0;
		
		for(int j = 0; j < n; j++) {
			int nodeIndex = toposort[j];
			
			if(distance[nodeIndex] != null) {
				List<Node> neighbours = graph.get(nodeIndex);
				
				for(Node node : neighbours) {
					int dis = distance[nodeIndex] + node.weight;
					if(distance[node.to] == null) {
						distance[node.to] = dis;
					} else {
						distance[node.to] = Math.min(dis, distance[node.to]);
					}
				}
			}
		}
		return distance;
	}
}

class Node {
	int to, weight;
	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
