package com.vivek.problems;

class Test {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode firstNode = null, lastNode =null, temp1 = result, temp2 = head;
        
        int count = 1;
        while (temp2 != null){
            if (count >= m && count <=n ) {
                ListNode temp3 = temp2;
                if(lastNode == null) {
                    firstNode = lastNode = temp3;
                    temp1.next = temp2.next;
                    temp2 = temp2.next;
                    count++;
                } else {
                    temp1.next = temp2.next;
                    temp2 = temp2.next;
                    count++;
                    temp3.next = firstNode;
                    firstNode = temp3;
                }
             
            } else {
                if(count < m) {
                    temp1 = temp2;
                    temp2 = temp2.next;
                    count++;
                } else {
                    break;
                }
            }
        }
        temp1.next = firstNode;
        lastNode.next = temp2;
        return result.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
	public static void main(String args []) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		int[] arr = new int[] {2,3,4,5};
		for(int a : arr) {
			temp.next = new ListNode(a);
			temp = temp.next;
		}
		
		ListNode temp1 = head;
		System.out.print("[");
		while(temp1 != null) {
			System.out.print(temp1.val+",");
			temp1 = temp1.next;
			
		}
		System.out.print("]");
		
		Test t = new Test();
		ListNode temp3 = t.reverseBetween(head, 2, 4);
		
		System.out.print("[");
		while(temp3 != null) {
			System.out.print(temp3.val+",");
			temp3 = temp3.next;
			
		}
		System.out.print("]");
	}
}