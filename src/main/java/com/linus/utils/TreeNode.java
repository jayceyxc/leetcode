package com.linus.utils;

/**
 * @author yuxuecheng
 * @Title TreeNode
 * @ProjectName leetcode
 * @Description TODO
 * @date 2020/6/17 17:12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
