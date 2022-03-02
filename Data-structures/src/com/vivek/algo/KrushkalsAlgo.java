package com.vivek.algo;

import java.util.Arrays;

public class KrushkalsAlgo {
	
	// representing graph edge with weight
	class Edge implements Comparable<Edge>{
		int src, des, weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	// used for union find to define parent 
	class Subset {
		int parent, rank;
	}
	
	Subset[] subsets;
	
	int V, E;  // V = no. of vertices, E = no. of edges
	
	// all edges which represents the graph
	Edge[] edges;
	
	public KrushkalsAlgo (int v, int e) {
		V = v;
		E = e;
		
		edges = new Edge[e];
		
		for(int i = 0; i < e; i++) {
			edges[i] = new Edge();
		}
	}

	
	public int find(Subset[] subsets, int v) {
		if(subsets[v].parent != v)
			subsets[v].parent = find(subsets, subsets[v].parent);
		return subsets[v].parent;
	}
	
	public void union(Subset[] subsets, int x, int y) {
		int xRoot = find(subsets, x);
		int yRoot = find(subsets, y);
		
		if(subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else if(subsets[xRoot].rank < subsets[yRoot].rank){
			subsets[xRoot].parent = yRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}
	
	void operateMST() {
		
		Edge[] result = new Edge[V -1];
		
		Arrays.sort(edges);
		
		int e = 0;
		int i = 0;
		
		subsets = new Subset[V];
		for(int k = 0; k < V; k++) {
			subsets[k] = new Subset();
			subsets[k].parent = k;
			subsets[k].rank = 0;
			
		}
		
		while(e < V - 1) {
			Edge next_edge = edges[i++];
			
			int parSrc = find(subsets, next_edge.src);
			int parDes = find(subsets, next_edge.des);
			
			if(parSrc != parDes) {
				result[e++] = next_edge;
				union(subsets, next_edge.src, next_edge.des);
			}
		}
		
		System.out.println("Minimum Spanning tree edges are: ");
		int minCost = 0;
		
		for(int j = 0; j < e; j++) {
			System.out.println("From  "+result[j].src+" -> "+result[j].des+",  weight: "+result[j].weight);
			minCost += result[j].weight;
		}
		
		System.out.println("Minimum Spanning tree Cost: "+minCost);
		
	}
	
	public static void main(String [] args) {
		KrushkalsAlgo graph = new KrushkalsAlgo(4, 5);
		  // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].des = 1;
        graph.edges[0].weight = 10;
 
        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].des = 2;
        graph.edges[1].weight = 6;
 
        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].des = 3;
        graph.edges[2].weight = 5;
 
        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].des = 3;
        graph.edges[3].weight = 15;
 
        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].des = 3;
        graph.edges[4].weight = 4;
        
        graph.operateMST();
	}
}
