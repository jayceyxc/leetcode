package com.linus.hard.merge_k_sorted_lists;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curNode = null;
        ListNode head = null;
        //保存各个链表的当前遍历节点
        TreeSet<ListNode> nodeTreeSet = new TreeSet<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                if (o1.val != o2.val) {
                    return Integer.compare(o1.val, o2.val);
                } else {
                    return -1;
                }
            }
        });
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            nodeTreeSet.add(list);
        }

        while (true) {
            ListNode polledNode = nodeTreeSet.pollFirst();
            if (polledNode == null) {
                break;
            }
            ListNode newNode = new ListNode(polledNode.val);
            newNode.next = null;
            if (curNode == null) {
                curNode = newNode;
            } else {
                curNode.next = newNode;
                curNode = newNode;
            }
            if (head == null) {
                head = curNode;
            }
            if (polledNode.next != null) {
                nodeTreeSet.add(polledNode.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{a, b, c, null};
        ListNode sortedListNode = new Solution().mergeKLists(lists);
        ListNode iterNode = sortedListNode;
        while(iterNode.next != null) {
            System.out.println(iterNode.val);
            iterNode = iterNode.next;
        }
        System.out.println(iterNode.val);

        a = new ListNode(1);
        lists = new ListNode[]{a};
        sortedListNode = new Solution().mergeKLists(lists);
        iterNode = sortedListNode;
        while(iterNode != null && iterNode.next != null) {
            System.out.println(iterNode.val);
            iterNode = iterNode.next;
        }
        if (iterNode != null) {
            System.out.println(iterNode.val);
        }

        lists = new ListNode[1];
        sortedListNode = new Solution().mergeKLists(lists);
        iterNode = sortedListNode;
        while(iterNode != null && iterNode.next != null) {
            System.out.println(iterNode.val);
            iterNode = iterNode.next;
        }
        if (iterNode != null) {
            System.out.println(iterNode.val);
        }

    }
}
