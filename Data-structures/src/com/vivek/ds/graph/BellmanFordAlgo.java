package com.vivek.ds.graph;
import java.util.*;

public class BellmanFordAlgo {
	
	public double[] bellmanFord(List<List<Node>> graph, int start) {
		int V = graph.size();
		double[] distance = new double[V];
		
		for(int i = 0; i < V; i++) {
			distance[i] = Double.POSITIVE_INFINITY;
		}
		distance[start] = 0;
		
		for(int i = 0; i < V-i; i++) {
			for(int j = 0; j < V; j++) {
				List<Node> neighbours = graph.get(j); // neighbours of j node
				for(Node neigh : neighbours) {
					double newDistance = distance[j] + neigh.weight;
					if(newDistance < distance[neigh.to]) {
						distance[neigh.to] = newDistance;
					}
				}
			}
		}
		
		for(int i = 0; i < V-i; i++) {
			for(int j = 0; j < V; j++) {
				List<Node> neighbours = graph.get(j); // neighbours of j node
				for(Node neigh : neighbours) {
					double newDistance = distance[j] + neigh.weight;
					if(newDistance < distance[neigh.to]) {
						distance[neigh.to] = Double.NEGATIVE_INFINITY;
					}
				}
			}
		}
		
		return distance;
	}
	
	
	public static void main(String args []) {
		List<List<Node>> graph = getGraph();
		int start = 0;
		BellmanFordAlgo bf = new BellmanFordAlgo();
		double[] distance = bf.bellmanFord(graph, start);
		
		for(int i = 0; i < graph.size(); i ++ ) {
			System.out.println("distance of "+i+" from 0 = "+distance[i]);
		}
	}
	
	
	private static List<List<Node>> getGraph() {
		List<List<Node>> graph = new ArrayList<List<Node>>();
		List<Node> node0 = new ArrayList<Node>();
		node0.add(new Node(1, 5));
		graph.add(node0);
		
		List<Node> node1 = new ArrayList<Node>();
		node1.add(new Node(2, 20));
		node1.add(new Node(5, 30));
		node1.add(new Node(6, 60));
		graph.add(node1);
		
		List<Node> node2 = new ArrayList<Node>();
		node2.add(new Node(3, 10));
		node2.add(new Node(4, 75));
		graph.add(node2);
		
		List<Node> node3 = new ArrayList<Node>();
		node3.add(new Node(2, -15));
		graph.add(node3);
		
		List<Node> node4 = new ArrayList<Node>();
		node4.add(new Node(9, 100));
		graph.add(node4);
		
		List<Node> node5 = new ArrayList<Node>();
		node5.add(new Node(4, 25));
		node5.add(new Node(6, 5));
		node5.add(new Node(8, 50));
		graph.add(node5);
		
		List<Node> node6 = new ArrayList<Node>();
		node6.add(new Node(7, -50));
		graph.add(node6);
		
		List<Node> node7 = new ArrayList<Node>();
		node7.add(new Node(8, -10));
		graph.add(node7);
		
		List<Node> node8 = new ArrayList<Node>();
		graph.add(node8);
		
		List<Node> node9 = new ArrayList<Node>();
		graph.add(node9);
		
		return graph;
	}

}
