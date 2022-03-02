package com.vivek.ds.graph;
import java.util.*;
public class IsomorphicTrees {
	
	
	public boolean isIsomorphic(List<List<Integer>> tree1, List<List<Integer>> tree2) {
		List<Integer> tree1Center = findCenter(tree1);
		List<Integer> tree2Center = findCenter(tree2);
		
		TreeNode root1 = rootTree(tree1, tree1Center.get(0));
		
		String unicodeTree1 = unicode(root1);
		System.out.println(unicodeTree1);
		for(int center : tree2Center) {
			TreeNode root2 = rootTree(tree2, center);
			String unicodeTree2 = unicode(root2);
			System.out.println(unicodeTree2);
			return unicodeTree1.equals(unicodeTree2);
				 
		}

		return false;
	}
	
	private List<Integer> findCenter(List<List<Integer>> graph) {
		List<Integer> leaves = new ArrayList<>();
		int count = 0;
		int degree[] = new int[graph.size()];
		
		
		for(int i = 0; i < graph.size(); i++) {
			degree[i] = graph.get(i).size();
			if(degree[i] == 0 || degree[i] == 1) {
				leaves.add(i);
				degree[i] = 0;
			}
		}
		
		count = leaves.size();
		while(count < graph.size()) {
			List<Integer> newLeaves = new ArrayList<>();
			for(int leaf : leaves) {
				List<Integer> neighbours = graph.get(leaf);
				for(int neighbour : neighbours) {
					degree[neighbour] = degree[neighbour] - 1;
					if(degree[neighbour] == 1) {
						newLeaves.add(neighbour);
						degree[neighbour] = 0;
					}
				}
			}
			leaves = newLeaves;
			count += leaves.size();
		}
		return leaves; //centers
	}
	
	private TreeNode rootTree(List<List<Integer>> graph, int rootId) {
		TreeNode root = new TreeNode(rootId, null, new ArrayList<>());
		
		return buildTree(graph, root, null);
	}
	
	private TreeNode buildTree(List<List<Integer>> graph, TreeNode node, TreeNode parent) {
		
		List<Integer> neighbours = graph.get(node.id);
		for(int neighbour : neighbours) {
			
			if(parent != null && neighbour == parent.id) continue;
		
			TreeNode child = new TreeNode(neighbour, node, new ArrayList<>());
			node.children.add(child);
			buildTree(graph, child, node);
		}
		return node;
	}
	
	
	private String unicode(TreeNode node) {
		if(node.children.isEmpty()) return "()";
		String str = "(";
		String childString = "";
		for(TreeNode child : node.children) {
			childString += unicode(child);
		}
		return str+childString+")";
	} 
	
	public static void main(String args []) {
		 List<List<Integer>> graph = new ArrayList<List<Integer>>();
			
			List<Integer> nbr0 = new ArrayList<>();
			nbr0.add(1);
			nbr0.add(2);
			nbr0.add(3);
			graph.add(nbr0);
			
			List<Integer> nbr1 = new ArrayList<>();
			nbr1.add(5);
			nbr1.add(4);
			nbr1.add(0);
			graph.add(nbr1);
			
			List<Integer> nbr2 = new ArrayList<>();
			nbr2.add(0);
			nbr2.add(6);
			graph.add(nbr2);
			
			List<Integer> nbr3 = new ArrayList<>();
			nbr3.add(0);
			graph.add(nbr3);
			
			List<Integer> nbr4 = new ArrayList<>();
			nbr4.add(1);
			graph.add(nbr4);
			
			
			List<Integer> nbr5 = new ArrayList<>();
			nbr5.add(1);
			graph.add(nbr5);
			
			List<Integer> nbr6 = new ArrayList<>();
			nbr6.add(2);
			graph.add(nbr6);
			
			
			
			//second graph
			List<List<Integer>> graph2 = new ArrayList<>();
			
			List<Integer> nbr02 = new ArrayList<>();
			nbr02.add(5);
			graph2.add(nbr02);
			
			List<Integer> nbr12 = new ArrayList<>();
			nbr12.add(2);
			graph2.add(nbr12);
			
			List<Integer> nbr22 = new ArrayList<>();
			nbr22.add(1);
			nbr22.add(3);
			nbr22.add(4);
			graph2.add(nbr22);
			
			List<Integer> nbr32 = new ArrayList<>();
			nbr32.add(2);
			graph2.add(nbr32);
			
			List<Integer> nbr42 = new ArrayList<>();
			nbr42.add(2);
			nbr42.add(5);
//			nbr42.add(6);
			graph2.add(nbr42);
			
			List<Integer> nbr52 = new ArrayList<>();
			nbr52.add(4);
			nbr52.add(0);
			graph2.add(nbr52);
			
//			List<Integer> nbr62 = new ArrayList<>();
//			nbr62.add(4);
//			graph2.add(nbr62);
			
			IsomorphicTrees it = new IsomorphicTrees();
			System.out.println("is isomorphic : "+it.isIsomorphic(graph, graph2));
	}
}

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

