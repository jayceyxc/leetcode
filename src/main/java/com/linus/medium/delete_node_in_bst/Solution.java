package com.linus.medium.delete_node_in_bst;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuxuecheng
 * @Title Solution
 * @ProjectName leetcode
 * @Description No.450 https://leetcode.com/problems/delete-node-in-a-bst/
 * @date 2020/6/8 10:23
 */


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private static final int NEXT_LEFT = 0;
    private static final int NEXT_RIGHT = 1;

    /**
     * 使用递归的方式删除节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                // 去到删除节点的右子树，找到值最小的节点
                TreeNode tempRoot = root.right;
                while (tempRoot.left != null) {
                    tempRoot = tempRoot.left;
                }
                // 将删除节点的左子树全部移到这个节点下
                tempRoot.left = root.left;

                // 返回右子树的根节点，放到当前删除节点的位置
                return root.right;
            }
        }
        return root;
    }

    public void displayInOrder(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                displayInOrder(root.left);
            }
            System.out.println(root.val);
            if (root.right != null) {
                displayInOrder(root.right);
            }
        }
    }

    public TreeNode generateBinaryTreeInOrder(Integer []values) {
        if (values == null || values.length == 0) {
            return null;
        }
        int curIndex = 0;
        int next = NEXT_LEFT;
        Queue<TreeNode> currentLeafNodeQueue = new LinkedBlockingQueue<>();
        TreeNode root = new TreeNode(values[curIndex]);
        TreeNode currentLeafNode = root;

        // 判断当前索引是否小于最后一个索引下标，防止越界
        while (curIndex < values.length - 1) {
            curIndex++;
            Integer value = values[curIndex];
            if (value == null) {
                if (next == NEXT_LEFT) {
                    next = NEXT_RIGHT;
                } else {
                    next = NEXT_LEFT;
                    currentLeafNode = currentLeafNodeQueue.poll();
                }

                continue;
            }

            if (currentLeafNode == null) {
                break;
            }

            TreeNode tempNode = new TreeNode(value);
            if (next == NEXT_LEFT) {
                currentLeafNode.left = tempNode;
                next = NEXT_RIGHT;
            } else {
                currentLeafNode.right = tempNode;
                currentLeafNode = currentLeafNodeQueue.poll();
                next = NEXT_LEFT;
            }
            currentLeafNodeQueue.add(tempNode);
        }

        return root;
    }

    public TreeNode generateOriginalTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        return root;
    }

    public void testCase1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        TreeNode newRoot = solution.deleteNode(root, 3);
        solution.displayInOrder(newRoot);
        System.out.println("test case 1 finished");
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        Integer[] values = {5, 3, 6, 2, 4, null, 7, 1, null, null, null, null, 8};
        TreeNode root = solution.generateBinaryTreeInOrder(values);

        TreeNode newRoot = solution.deleteNode(root, 3);
        solution.displayInOrder(newRoot);
        System.out.println();

        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 7);
        solution.displayInOrder(newRoot);
        System.out.println();

        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 5);
        solution.displayInOrder(newRoot);
        System.out.println();

        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 6);
        solution.displayInOrder(newRoot);
        System.out.println();

        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 2);
        solution.displayInOrder(newRoot);
        System.out.println();

        values = new Integer[]{0};
        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 0);
        solution.displayInOrder(newRoot);
        System.out.println();

        values = new Integer[]{1, null, 2};
        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 1);
        solution.displayInOrder(newRoot);
        System.out.println();

        values = new Integer[]{5, 3, 6, 2, 4, null, 7};
        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 3);
        solution.displayInOrder(newRoot);
        System.out.println();

        values = new Integer[]{40,38,46,6,39,43,48,3,8,null,null,42,44,47,49,0,5,7,34,41,null,null,45,null,null,null,null,null,1,4,null,null,null,32,37,null,null,null,null,null,2,null,null,16,33,35,null,null,null,11,27,null,null,null,36,10,15,20,31,null,null,9,null,13,null,17,23,29,null,null,null,12,14,null,18,22,26,28,30,null,null,null,null,null,19,21,null,24,null,null,null,null,null,null,null,null,null,null,25};
        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 40);
        solution.displayInOrder(newRoot);
        System.out.println();

        values = new Integer[]{5,3,6,2,4,null,7};
        root = solution.generateBinaryTreeInOrder(values);
        newRoot = solution.deleteNode(root, 0);
        solution.displayInOrder(newRoot);
        System.out.println();
    }
}
