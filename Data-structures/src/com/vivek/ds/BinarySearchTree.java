package com.vivek.ds;

import java.util.ConcurrentModificationException;

import com.vivek.practice.BSTPrac1.Node;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	private int nodeCount;
	
	public class Node {
		public T data;
		public Node left;
		public Node right;
		
		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		

		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	public boolean contains(T elem) {
		return isContains(root, elem);
	}
	
	private boolean isContains(Node node, T elem) {
		while(node != null) {
			int cmp = node.data.compareTo(elem);
			if(cmp == 0) {
				return true;
			}else if(cmp > 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return false;
	}
	
	public boolean add(T elem) {
		if(contains(elem)) return false;
		
		root = add(root, elem);
		nodeCount++;
		return true;
	}
	
	private Node add (Node node, T elem) {
		if(node == null) {
			node = new Node(elem, null, null);
		} else {
			if(elem.compareTo(node.data) > 0) {
				node.right = add( node.right, elem);
			} else {
				node.left = add( node.left, elem);
			}
		}
		
		return node;
	}

	public boolean remove(T elem) {
		if(contains(elem)) {
			root = remove(root, elem);
			nodeCount--;
			return true;
		}
		
		return false;
	}
	
	public Node remove(Node node, T elem) {
		int cmp = elem.compareTo(node.data);
		if(cmp == 0) {
			if(node.left == null) {
				//only right node is there
				Node temp = node.right;
				node.data = null;
				node = null;
				return temp;
			} else if (node.right == null) {
				//only left node is there
				Node temp = node.left;
				node.data = null;
				node = null;
				return temp;
			} else {
				/*neither of the subtree is null, replace node with max of left or min of right*/
				Node trav = node.left;
				while(trav.right != null) {
					trav = trav.right;
				}
				node.data = trav.data;
				remove(node.left, trav.data);
			}
		} else if(cmp > 0) {
			node.right = remove(node.right, elem);
		} else {
			node.left = remove(node.left, elem);
		}
		return node;
	}

	public java.util.Iterator<T> inOrderTraversal() {
		final StackImp<Node> stack = new StackImp<>();
		final int tempNodeCount = nodeCount;		
		stack.push(root);

		return new java.util.Iterator<T>() {
			Node trav = root;

			@Override
			public boolean hasNext() {
				if(tempNodeCount != nodeCount) throw new ConcurrentModificationException();
				return (root != null && !stack.isEmpty());
			}

			@Override
			public T next() {
				while(trav.left != null) {
					stack.push(trav.left);
					trav = trav.left;
				}
				Node node = stack.pop();
				if(node.right != null) {
					stack.push(node.right);
					trav = node.right;
				}
				return node.data;
			}
		};
	}

	public java.util.Iterator<T> preOrderTraversal() {
		int expectedNodeCount = nodeCount;
		StackImp<Node> stack = new StackImp<>();
		stack.push(root);
		
		return new java.util.Iterator<T>() {

			@Override
			public boolean hasNext() {
				if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
				return root != null && !stack.isEmpty();
			}

			@Override
			public T next() {
				Node node = stack.pop();
				if(node.right!=null) {
					stack.push(node.right);
				}
				if(node.left != null) {
					stack.push(node.left);
				}
				return node.data;
				
			}
			
		};
	}
	
	public java.util.Iterator<T> postOrderTraversal() {
		int expectedNodeCount = nodeCount;
		StackImp<Node> stack1 = new StackImp<>();
		StackImp<Node> stack2 = new StackImp<>();
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			Node node = stack1.pop();
			stack2.push(node);
			if(node.left != null) stack1.push(node.left);
			if(node.right != null) stack1.push(node.right);
		}
		
		return new java.util.Iterator<T>() {

			@Override
			public boolean hasNext() {
				if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
				
				return root != null && !stack2.isEmpty();
			}

			@Override
			public T next() {
				if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
				return stack2.pop().data;
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
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	
}
