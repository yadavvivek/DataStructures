package com.vivek.ds.graph;

import java.util.*;
public class GraphTreeToRootedTree {
	
	private TreeNode mRoot;
	
	//Node object
	class TreeNode {
		int id;
		TreeNode parent;
		List<TreeNode> children;
		
		public TreeNode(int id, TreeNode parent, List<TreeNode> children) {
			this.id = id;
			this.parent = parent;
			this.children = children;
		}
	}
	
	// public api to root, pass the id(index) which you want to root
	public TreeNode rootTree(List<List<Integer>> graph, int id) {
		mRoot = new TreeNode(id, null, new ArrayList<>());
		return buildTree(graph, mRoot, null);
	}

	// rooting the tree with the help of root node...
	private TreeNode buildTree(List<List<Integer>> g, TreeNode node, TreeNode parent) {
		List<Integer> neighbours = g.get(node.id);
		
		for(int neighbour : neighbours) {

			if(parent != null && neighbour == parent.id) continue;

			TreeNode child = new TreeNode(neighbour, node, new ArrayList<>());
			node.children.add(child);
			buildTree(g, child, node);
		}

		return node;
	}
	
	//Using level order traversal to print the tree
	public void printTree() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(mRoot);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.print("  "+node.id);
			
			for(TreeNode child : node.children) {
				queue.add(child);
			}
		}
	}
	
	
	//main method for execution...
	public static void main(String args []) {
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		List<Integer> nbr0 = new ArrayList<>();
		nbr0.add(1);
		nbr0.add(3);
		nbr0.add(4);
		graph.add(new ArrayList<>(nbr0));
		
		List<Integer> nbr1 = new ArrayList<>();
		nbr1.add(2);
		nbr1.add(5);
		nbr1.add(6);
		nbr1.add(0);
		graph.add(nbr1);
		
		List<Integer> nbr2 = new ArrayList<>();
		nbr2.add(1);
		graph.add(nbr2);
		
		List<Integer> nbr3 = new ArrayList<>();
		nbr3.add(0);
		graph.add(nbr3);
		
		List<Integer> nbr4 = new ArrayList<>();
		nbr4.add(0);
		nbr4.add(8);
		nbr4.add(9);
		graph.add(nbr4);
		
		
		List<Integer> nbr5 = new ArrayList<>();
		nbr5.add(1);
		graph.add(nbr5);
		
		List<Integer> nbr6 = new ArrayList<>();
		nbr6.add(1);
		nbr6.add(7);
		graph.add(nbr6);
		
		List<Integer> nbr7 = new ArrayList<>();
		nbr7.add(6);
		graph.add(nbr7);
		
		List<Integer> nbr8 = new ArrayList<>();
		nbr8.add(4);
		graph.add(nbr8);
		
		List<Integer> nbr9 = new ArrayList<>();
		nbr9.add(4);
		graph.add(nbr9);
		
		GraphTreeToRootedTree rt = new GraphTreeToRootedTree();
		rt.rootTree(graph, 1);
		
		rt.printTree();
		System.out.println();
		GraphTreeToRootedTree rt2 = new GraphTreeToRootedTree();
		rt2.rootTree(graph, 0);
		rt2.printTree();
		System.out.println();
		GraphTreeToRootedTree rt3 = new GraphTreeToRootedTree();
		rt3.rootTree(graph, 4);
		rt3.printTree();
	}
}
