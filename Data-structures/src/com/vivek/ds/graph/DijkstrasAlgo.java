package com.vivek.ds.graph;

import java.util.*;

import com.vivek.ds.IndexedPriorityQueue;
import com.vivek.ds.MinIndexedDHeap;

public class DijkstrasAlgo {
	
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
		
		DijkstrasAlgo dikAlgo = new DijkstrasAlgo();
		int start = 0;
		Integer [] distance = dikAlgo.singlerSourceShortestPath(graph, start);
		
		for(int i = 0; i < distance.length; i++) {
			System.out.print("["+map.get(start)+"-> "+map.get(i)+": "+distance[i]+"] ");
		}
		
	}

	
	public Integer[] singlerSourceShortestPath(List<List<Node>> graph, int start) {
		int N = graph.size();
		Integer[] distance = new Integer[N];
		boolean[] visited = new boolean[N];
		MinIndexedDHeap<Integer> pq = new MinIndexedDHeap<>(2, N);
		pq.insert(start, 0);
		distance[start] = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			System.out.println("==========="+ (++count)+"===============");
			int nodeIndex = pq.peekMinKeyIndex();
			int dis = pq.pollMinValue();
			visited[nodeIndex] = true;
			List<Node> neighbours = graph.get(nodeIndex);
			
			for(Node neighbour : neighbours) {
				if (visited[neighbour.to]) continue;
				int newDistance = dis + neighbour.weight;
				if(distance[neighbour.to] == null || newDistance < distance[neighbour.to]) {
					distance[neighbour.to] = newDistance;
					if(pq.contains(neighbour.to)) {
						pq.decrease(neighbour.to, newDistance);
					} else {
						pq.insert(neighbour.to, newDistance);
					}
				}				
			}
		}
		
		return distance;
	}
	
 }
