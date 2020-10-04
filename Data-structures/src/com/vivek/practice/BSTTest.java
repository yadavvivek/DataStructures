package com.vivek.practice;

import java.util.Iterator;

import com.vivek.ds.BinarySearchTree;
import com.vivek.ds.BinarySearchTree.Node;

public class BSTTest {

	public static void main(String[] args) {
		BSTPrac1<Integer> bst = new BSTPrac1<>();
		bst.add(10);
		bst.add(8);
		bst.add(9);
		bst.add(12);
		bst.add(13);
		bst.add(6);
		
//		Iterator<Integer> it = bst.inOrderTraversal();
		Iterator<Integer> it = bst.getInOrderIterator();
		
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println("Height : "+bst.height());
//		Iterator<Integer> pit = bst.preOrderTraversal();
		Iterator<Integer> pit = bst.getPreOrderIterator();
		while(pit.hasNext()) {
			System.out.print(pit.next()+" ");
		}
		
		System.out.println();
//		Iterator<Integer> itp = bst.postOrderTraversal();
		Iterator<Integer> itp = bst.getPostOrderIterator();
		while(itp.hasNext()) {
			System.out.print(itp.next()+" ");
		}
		
		bst.remove(6);
		bst.remove(10);
		bst.remove(13);
//        Iterator<Integer> itt = bst.inOrderTraversal();
		Iterator<Integer> itt = bst.getLevelOrderIterator();
        System.out.println("Height : "+bst.height());
		while(itt.hasNext()) {
			System.out.print(itt.next()+" ");
		}
	}
}
