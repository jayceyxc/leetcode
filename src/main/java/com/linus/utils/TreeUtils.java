package com.linus.utils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuxuecheng
 * @Title TreeUtils
 * @ProjectName leetcode
 * @Description TODO
 * @date 2020/6/17 17:12
 */
public class TreeUtils {
    private static final int NEXT_LEFT = 0;
    private static final int NEXT_RIGHT = 1;

    public static TreeNode generateBinaryTreeInLevelOrder(Integer []values) {
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
}
