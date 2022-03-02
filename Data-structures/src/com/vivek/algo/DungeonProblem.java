package com.vivek.algo;

import java.util.*;

public class DungeonProblem {
	
	private String m[][];
	private boolean[][] visited;
	private int nodeCount;
	private int node_left_in_layer = 1;
	private int node_in_next_layer = 0;
	private Queue<Integer> rowQ;
	private Queue<Integer> columnQ;
	
	private int R;
	private int C;
	
	private int sr, sc;
	
	private boolean reachedEnd;
	
	private static final int[] dr = {-1, 1, 0,  0};
	private static final int[] dc = { 0, 0, 1, -1};
	
	
	public DungeonProblem(String[][] m) {
		this.m = m;
		sr = 0;
		sc = 0;
		R = m.length;
		C = m[0].length;
		visited = new boolean[m.length][m[0].length];
	}
	
	public int solve() {
		rowQ = new LinkedList<>();
		columnQ = new LinkedList<>();
		
		rowQ.add(sr);
		columnQ.add(sc);
		visited[sr][sc] = true;
		
		while(!rowQ.isEmpty()) { //or !columnQ.isEmpty()
			int r = rowQ.remove();
			int c = columnQ.remove();
			
			if(m[r][c] == "E") {
				reachedEnd = true;
				break;
			}
			
			exploreNeighbours(r,c);
			node_left_in_layer--;
			if(node_left_in_layer == 0) {
				nodeCount++;
				node_left_in_layer = node_in_next_layer;
				node_in_next_layer = 0;
			}
		}
		
		if(reachedEnd)
			return nodeCount;
		
		return -1;
	}
	
	private void exploreNeighbours(int r, int c) {
		for(int i = 0; i < 4; i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			
			if(rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
			
			if(visited[rr][cc] || m[rr][cc] == "#") continue;
			
			rowQ.add(rr);
			columnQ.add(cc);
			node_in_next_layer++;
			visited[rr][cc] = true;
		}
	}
	
	public static void main(String args []) {
		String [][] m = {
				{"S",".","E","#",".",".","."},
				{".","#",".","#",".","#","."},
				{".","#",".",".",".",".","."},
				{".",".","#","#",".",".","."},
				{"#",".","#","#",".","#","."}
			};
		DungeonProblem dp = new DungeonProblem(m);
		System.out.println(dp.solve());
 	}
}
