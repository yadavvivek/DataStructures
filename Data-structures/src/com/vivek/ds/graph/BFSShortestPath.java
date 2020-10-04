package com.vivek.ds.graph;

import java.util.*;

import com.vivek.ds.QueueImp;

public class BFSShortestPath {

	Map<Integer, ArrayList<Integer>> mGraph;
	QueueImp<Integer> queue = new QueueImp<>();
	Boolean[] visited = {false, false, false, false, false, false, false};
	Object [] prev = new Object[7];

	public BFSShortestPath(Map<Integer, ArrayList<Integer>> graph) {
		mGraph = graph;
	}

	public String findShortestPath(int s, int e) {
		int[] shortestpath = new int[7];
		Object[] p = bfs(s);
		int index = 1;
		for(int at = e; p[at] != null; at = (int)p[at]) {
			shortestpath[index++] = (int) p[at];
		}

		if(shortestpath[index-1] != s) {
			shortestpath = null;
			return "[]";
		} else {
			shortestpath[0] = e;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = index-1; i >= 0; i--) {
			sb.append(shortestpath[i]);
			sb.append(", ");
		}
		return sb.toString();
	}

	private Object[] bfs(int s) {
		queue.offer(s);
		visited[s] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int neighbor: mGraph.get(node)) {
				if(!visited[neighbor]) {					
					queue.offer(neighbor);
					visited[neighbor] = true;
					prev[neighbor] = node;
				}
			}
		}
		return prev;
	}
	
	public static void main(String args []) {
		Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(2); arr1.add(3); arr1.add(4);
		graph.put(1, arr1);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		graph.put(2, arr2);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(5); arr3.add(1);
		graph.put(3, arr3);
		
		ArrayList<Integer> arr4 = new ArrayList<Integer>();
		arr4.add(1); arr4.add(6);
		graph.put(4, arr4);
		
		ArrayList<Integer> arr5 = new ArrayList<Integer>();
		arr5.add(3); arr5.add(6);
		graph.put(5, arr5);
		
		ArrayList<Integer> arr6 = new ArrayList<Integer>();
		arr6.add(4); arr6.add(5);
		graph.put(6, arr6);
		
		BFSShortestPath spath = new BFSShortestPath(graph);
		
		System.out.println("sortestPath: "+spath.findShortestPath(1, 6));
	}

}
