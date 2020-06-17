package com.linus.medium.binary_tree_inorder_traversal;

import com.linus.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxuecheng
 * @Title Solution
 * @ProjectName leetcode
 * @Description TODO
 * @date 2020/6/5 18:20
 */

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }
            System.out.println(root.val);
            result.add(root.val);
            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode((3));
        root.left = null;
        root.right = a;
        a.left = b;
        a.right = null;
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
    }
}
