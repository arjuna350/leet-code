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
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void printList() {
		// System.out.println(val);
		ListNode temp = this;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}

public class AddLinkedList {

	private ListNode output;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null)
			return null;

		ListNode l3 = null;
		if (l1.next != null && l2.next != null)
			l3 = this.addTwoNumbers(l1.next, l2.next);

		if (l3 == null) {
			int i = l1.val + l2.val;
			int value = i % 10;
			int carryForward = i / 10;

			ListNode listNode = new ListNode(value);

			ListNode currentNode = new ListNode(carryForward);
			currentNode.next = listNode;
			l3 = currentNode;
		}

		else {
			int i = l1.val + l2.val + l3.val;
			int value = i % 10;
			int carryForward = i / 10;

			ListNode listNode = new ListNode(value);
			listNode.next = l3.next;
			ListNode currentNode = new ListNode(carryForward);
			currentNode.next = listNode;
			l3 = currentNode;
		}

		return l3;

	}

	public static void main(String[] args) {
		AddLinkedList addLinkedList = new AddLinkedList();
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
		
		ListNode result =addLinkedList.addTwoNumbers(l1, l2);
		result.printList();
		

	}

}
