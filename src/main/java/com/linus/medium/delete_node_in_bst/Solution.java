package com.linus.medium.delete_node_in_bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode deleteNode = root;
        TreeNode prevNode = root;
        // deleteNode是否为prevNode的左子树
        boolean isLeft = true;
        while (true) {
            if (deleteNode != null) {
                if (deleteNode.val == key) {
                    if (deleteNode.left == null && deleteNode.right == null) {
                        if (deleteNode == root) {
                            root = null;
                        } else {
                            if (isLeft) {
                                prevNode.left = null;
                            } else {
                                prevNode.right = null;
                            }
                        }
                    } else if (deleteNode.left == null) {
                        if (deleteNode == root) {
                            root = root.right;
                        } else {
                            if (isLeft) {
                                prevNode.left = deleteNode.right;
                            } else {
                                prevNode.right = deleteNode.right;
                            }
                        }
                    } else if (deleteNode.right == null) {
                        if (deleteNode == root) {
                            root = root.left;
                        } else {
                            if (isLeft) {
                                prevNode.left = deleteNode.left;
                            } else {
                                prevNode.right = deleteNode.left;
                            }
                        }
                    } else {
                        TreeNode tempRoot = deleteNode.right;
                        while (tempRoot.left != null) {
                            tempRoot = tempRoot.left;
                        }
                        tempRoot.left = deleteNode.left;
                        if (deleteNode == root) {
                            root.right = tempRoot.right;
                            tempRoot.right = root.right;
                            root = tempRoot;
                        } else {
                            if (isLeft) {
                                prevNode.left = deleteNode.right;
                            } else {
                                prevNode.right = deleteNode.right;
                            }
                        }
                    }
                    break;
                } else if (deleteNode.val > key) {
                    prevNode = deleteNode;
                    deleteNode = deleteNode.left;
                    isLeft = true;
                } else {
                    prevNode = deleteNode;
                    deleteNode = deleteNode.right;
                    isLeft = false;
                }
            } else {
                break;
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
    }
}
