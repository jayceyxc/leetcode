package com.linus.medium.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curNode = null;
        ListNode l1Node = null;
        ListNode l2Node = null;
        if ((l1 == null) && (l2 == null)){
            return null;
        } else if ((l1 != null) && (l2 == null)){
            return l1;
        } else if ((l1 == null) && (l2 != null)) {
            return l2;
        } else {
            boolean carry = false;
            int value = l1.val + l2.val;
            if (value >= 10) {
                carry = true;
            }
            result = new ListNode(value % 10);
            result.next = null;
            curNode = result;
            l1Node = l1.next;
            l2Node = l2.next;
            while ((l1Node != null) && (l2Node != null)) {
                value = l1Node.val + l2Node.val;
                if (carry) {
                    value += 1;
                    carry = false;
                }
                if (value >= 10) {
                    carry = true;
                }
                ListNode newNode = new ListNode(value % 10);
                newNode.next = null;
                curNode.next = newNode;
                curNode = curNode.next;
                l1Node = l1Node.next;
                l2Node = l2Node.next;
            }
            while (l1Node != null) {
                value = l1Node.val;
                if (carry) {
                    value += 1;
                    carry = false;
                }
                if (value >= 10) {
                    carry = true;
                }
                ListNode newNode = new ListNode(value % 10);
                newNode.next = null;
                curNode.next = newNode;
                curNode = curNode.next;
                l1Node = l1Node.next;
            }
            while (l2Node != null) {
                value = l2Node.val;
                if (carry) {
                    value += 1;
                    carry = false;
                }
                if (value >= 10) {
                    carry = true;
                }
                ListNode newNode = new ListNode(value % 10);
                newNode.next = null;
                curNode.next = newNode;
                curNode = curNode.next;
                l2Node = l2Node.next;
            }
            if (carry) {
                ListNode newNode = new ListNode(1);
                newNode.next = null;
                curNode.next = newNode;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        a.next = new ListNode(5);
        a.next.next = new ListNode(8);
        ListNode b = new ListNode(3);
        b.next = new ListNode(4);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(1);
        ListNode result = new Solution().addTwoNumbers(a, b);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        a = new ListNode(1);
        b = new ListNode(9);
        b.next = new ListNode(9);
        b.next.next = new ListNode(9);
        result = new Solution().addTwoNumbers(a, b);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
