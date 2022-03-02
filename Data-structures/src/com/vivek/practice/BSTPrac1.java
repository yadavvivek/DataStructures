package com.vivek.practice;

import com.vivek.ds.QueueImp;
import com.vivek.ds.StackImp;

public class BSTPrac1<T extends Comparable<T>> {
	
	private int mNodeCount;
	
	private Node root;
	
	public class Node {
		Node left, right;
		T data;
		public Node( Node left, Node right, T data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	public int size() {
		return mNodeCount;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean add(T elem) {
		if(contains(elem)) {
			return false;
		} else {
			root = add(root, elem);
			mNodeCount++;
			return true;
		}
	}
	
	private Node add(Node node, T elem) {
		if(node == null) {
			node = new Node(null, null, elem);
		} else {
			if(elem.compareTo(node.data) < 0) {
				node.left = add(node.left, elem);
			} else {
				node.right = add(node.right, elem);
			}
		}
		return node;
	}
	
	public boolean remove(T elem) {
		if(contains(elem)) {
			root = remove(root, elem);
			mNodeCount--;
			return true;
		}
		return false;
	}
	
	private Node remove(Node node, T elem) {
		if(node == null) return null;
		int cmp = elem.compareTo(node.data);
		
		if(cmp < 0) {
			node.left = remove(node.left, elem);
		} else if (cmp > 0) {
			node.right = remove(node.right, elem);
		} else {
			if(node.left == null) {
				Node leftChild = node.right;
				node.data = null;
				node = null;
				return leftChild;
			}else if( node.right == null) {
				Node rightChild = node.left;
				node.data = null;
				node = null;
				return rightChild;
			} else {
				Node temp = digRight(node.left, elem);
				node.data = temp.data;
				remove(node.left, elem);
			}
		}
		return node;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	private Node digRight(Node node, T data) {
		Node temp = node;
		while(temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
	
	public boolean contains(T elem) {
		return contains(root, elem);
	}
	
	private boolean contains(Node node, T elem) {
		if(node == null) return false;
		int cmp = elem.compareTo(node.data);
		if(cmp < 0) {
			return contains(node.left, elem);
		} else if (cmp > 0){
			return contains(node.right, elem);
		} else {
			return true;
		}
	}
	
	public java.util.Iterator<T> getPreOrderIterator() {
		StackImp<Node> stack = new StackImp<Node>();
		stack.push(root);
		
		return new java.util.Iterator<T>() {
	
			@Override
			public boolean hasNext() {
				return !stack.isEmpty();
			}

			@Override
			public T next() {
				Node node = stack.pop();
				if(node.right != null) {
					stack.push(node.right);
				}
				if(node.left != null) {
					stack.push(node.left);
				}
				return node.data;
			}
			
		};
	}
	
	public java.util.Iterator<T> getInOrderIterator() {
		
		StackImp<Node> stack = new StackImp<Node>();
		stack.push(root);
		
		return new java.util.Iterator<T>() {
			Node trav = root;
			@Override
			public boolean hasNext() {
				return root != null && !stack.isEmpty();
			}

			@Override
			public T next() {
				while(trav.left != null) {
					trav = trav.left;
					stack.push(trav);
				}
				
				Node temp = stack.pop();
				if(temp.right != null) {
					stack.push(temp.right);
					trav = temp.right;
				}
				
				return temp.data;
			}
		};
	}
	
	public java.util.Iterator<T> getPostOrderIterator() {
		
		StackImp<Node> stackTemp = new StackImp<>();
		StackImp<Node> stackFinal = new StackImp<>();
		
		stackTemp.push(root);
		
		while(!stackTemp.isEmpty()) {
			Node node = stackTemp.pop();
			if(node.left != null) {
				stackTemp.push(node.left);
			}
			if(node.right != null) {
				stackTemp.push(node.right);
			}
			stackFinal.push(node);
		}
		
		return new java.util.Iterator<T> () {

			@Override
			public boolean hasNext() {
				return root != null && !stackFinal.isEmpty();
			}

			@Override
			public T next() {
				return stackFinal.pop().data;
			}
			
		};
	}
	
	public java.util.Iterator<T> getLevelOrderIterator() {
		
		QueueImp<Node> queue = new QueueImp<>();
		queue.offer(root);
		
		return new java.util.Iterator<T>() {

			@Override
			public boolean hasNext() {
				return root != null && !queue.isEmpty();
			}

			@Override
			public T next() {
				Node node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				return node.data;
			}
		};
	}
}
