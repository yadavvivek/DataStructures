package com.vivek.ds.graph;

import java.util.*;

import com.vivek.ds.MinIndexedDHeap;

public class DijkstrasAlgoPath {
	
	public List<Integer[]> singleSourceSortestPath(List<List<Node>> graph, int start) {
		List<Integer[]> result = new ArrayList<>();
		int N = graph.size();
		
		boolean[] visited = new boolean[N];
		Integer[] distance = new Integer[N];
		Integer[] prev = new Integer[N];
		distance[start] = 0;
		MinIndexedDHeap<Integer> pq = new MinIndexedDHeap<Integer>(2, N);
		pq.insert(start, 0);
		
		while(!pq.isEmpty()) {
			int index = pq.peekMinKeyIndex();
			int dis = pq.pollMinValue();
			visited[index] = true;
			List<Node> neis = graph.get(index);
			
			for(Node nei : neis) {
				int newDistance = dis + nei.weight;
				if(distance[nei.to] == null || newDistance < distance[nei.to]) {
					distance[nei.to] = newDistance;
					prev[nei.to] = index;
					if(pq.contains(nei.to))
						pq.decrease(nei.to, newDistance);
					else
						pq.insert(nei.to, newDistance);
				}
			}
		}
		
		result.add(distance);
		result.add(prev);
		
		return result;
	}
	
	public static void main(String args []) {
		Map<Integer, String> map = getMap();
		List<List<Node>> graph = getGraph();
		
		DijkstrasAlgoPath dp = new DijkstrasAlgoPath();
		
		int start = 0;
		
		List<Integer[]> disAndPath = dp.singleSourceSortestPath(graph, start);
		Integer [] distance = disAndPath.get(0);
		Integer [] prev = disAndPath.get(1);
		
		for(int i = 0; i < distance.length; i++) {
			System.out.print("["+map.get(start)+"-> "+map.get(i)+": "+distance[i]+"] ");
		}
		
		//find the shortest path A to H (0 to 7)
		Stack<Integer> stack = new Stack<>();
	    int end = 6;
	    stack.push(end);
	    while(end > 0) {
	    	end = prev[end];
	    	stack.push(end);
	    }
	    System.out.println();
	    while(!stack.isEmpty()) {
	    	System.out.print(map.get(stack.pop())+" -> ");
	    }
	}
	
	
	private static Map<Integer, String> getMap() {
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
		
		return map;
	}
	
	private static List<List<Node>> getGraph() {
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
		
		return graph;
	}
}
