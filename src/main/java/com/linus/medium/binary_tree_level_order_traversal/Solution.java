package com.linus.medium.binary_tree_level_order_traversal;

import com.linus.utils.TreeNode;
import com.linus.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuxuecheng
 * @Title Solution
 * @ProjectName leetcode
 * @Description No 102. https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @date 2020/6/17 13:58
 */

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> nextLevelNodeList = new ArrayList<>();
        List<TreeNode> currentLevelNodeList = new ArrayList<>();
        currentLevelNodeList.add(root);
        while (currentLevelNodeList.size() != 0) {
            List<Integer> currentLevelValueList = new ArrayList<>();
            for (TreeNode treeNode : currentLevelNodeList) {
                currentLevelValueList.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevelNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevelNodeList.add(treeNode.right);
                }
            }
            result.add(currentLevelValueList);
            currentLevelNodeList.clear();
            currentLevelNodeList.addAll(nextLevelNodeList);
            nextLevelNodeList.clear();
        }

        return result;
    }

    /**
     * 使用一个队列来实现遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderUseQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedBlockingQueue<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int levelNum = treeNodeQueue.size();
            List<Integer> levelResult = new ArrayList<>();
            while (levelNum > 0) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode != null) {
                    levelResult.add(treeNode.val);
                    if (treeNode.left != null) {
                        treeNodeQueue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodeQueue.offer(treeNode.right);
                    }
                }
                levelNum--;
            }
            result.add(levelResult);
        }

        return result;
    }

    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        levelHelper(result, root, 0);
        return result;
    }

    private void levelHelper(List<List<Integer>> result, TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (height == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(node.val);
        levelHelper(result, node.left, height + 1);
        levelHelper(result, node.right, height + 1);
    }

    private void displayResult(List<List<Integer>> result) {
        System.out.println("[");
        for (List<Integer> integerList : result) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[");
            for (Integer value : integerList) {
                sb.append(value);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("],");
            System.out.println(sb.toString());
        }
        System.out.println("]");
    }

    private void testCase1() {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeUtils.generateBinaryTreeInLevelOrder(values);
        List<List<Integer>> result = levelOrderByDFS(root);
        displayResult(result);
    }

    private void testCase2() {
        Integer[] values = {5,3,6,2,4,null,7};
        TreeNode root = TreeUtils.generateBinaryTreeInLevelOrder(values);
        List<List<Integer>> result = levelOrderByDFS(root);
        displayResult(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testCase1();
        solution.testCase2();
    }
}
