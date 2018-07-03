package com.shailesh.linkedList;

/**
 * Definition for singly-linked list.
 * You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *   Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 */

public class AddLinkedListSimple {

	

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null)
			return null;

		int i = l1.val + l2.val ;
		int value = i % 10;
		int carryForward = i / 10;
		
		ListNode l3=new ListNode(value);
		ListNode result=l3;
		
		
		while(l1.next!=null || l2.next!=null)
		{
			if(l1.next!=null)
				l1=l1.next;
			if(l2.next!=null)
				l2=l2.next;
			
			i = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) +carryForward;
			value = i % 10;
			carryForward = i / 10;
			
			ListNode current=new ListNode(value);
			l3.next=current;
			l3=current;
		}
		
		if(carryForward>0)
		{
			ListNode current=new ListNode(carryForward);
			l3.next=current;
		}

		return result;

	}

	public static void main(String[] args) {
		AddLinkedListSimple addLinkedList = new AddLinkedListSimple();
		ListNode l1 = new ListNode(2);
		ListNode l10 = new ListNode(4);
		ListNode l11 = new ListNode(3);
		l1.next = l10;
		l10.next = l11;
		l1.printList();

		ListNode l2 = new ListNode(5);
		ListNode l20 = new ListNode(6);
		ListNode l21 = new ListNode(4);
		l2.next = l20;
		l20.next = l21;

		l2.printList();
		
		System.out.println("Addition Result");
		ListNode result =addLinkedList.addTwoNumbers(l1, l2);
		result.printList();
		

	}

}
