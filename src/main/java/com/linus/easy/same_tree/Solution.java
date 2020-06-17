package com.linus.easy.same_tree;

import com.linus.utils.TreeNode;
import com.linus.utils.TreeUtils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuxuecheng
 * @Title Solution
 * @ProjectName leetcode
 * @Description No 100, https://leetcode.com/problems/same-tree/
 * @date 2020/6/17 16:59
 */

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 都为空返回true
            return true;
        } else if (p == null || q == null) {
            // 只有一个为空，则返回false
            return false;
        } else {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
    }

    private void testCase1() {
        Integer[] values1 = {1, 2, 3};
        Integer[] values2 = {1, 2, 3};
        TreeNode root1 = TreeUtils.generateBinaryTreeInLevelOrder(values1);
        TreeNode root2 = TreeUtils.generateBinaryTreeInLevelOrder(values2);
        boolean result = isSameTree(root1, root2);
        assert result;
        System.out.println("testCase1 passed");
    }

    private void testCase2() {
        Integer[] values1 = {1, 2};
        Integer[] values2 = {1, null, 2};
        TreeNode root1 = TreeUtils.generateBinaryTreeInLevelOrder(values1);
        TreeNode root2 = TreeUtils.generateBinaryTreeInLevelOrder(values2);
        boolean result = isSameTree(root1, root2);
        assert !result;
        System.out.println("testCase2 passed");
    }

    private void testCase3() {
        Integer[] values1 = {1, 2, 1};
        Integer[] values2 = {1, 1, 2};
        TreeNode root1 = TreeUtils.generateBinaryTreeInLevelOrder(values1);
        TreeNode root2 = TreeUtils.generateBinaryTreeInLevelOrder(values2);
        boolean result = isSameTree(root1, root2);
        assert !result;
        System.out.println("testCase3 passed");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testCase1();
        solution.testCase2();
        solution.testCase3();
    }
}
