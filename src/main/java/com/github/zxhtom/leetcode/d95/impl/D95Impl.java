package com.github.zxhtom.leetcode.d95.impl;

import com.github.zxhtom.leetcode.d95.D95;
import com.github.zxhtom.leetcode.d95.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/11
 */
public class D95Impl implements D95 {
    @Override
    public List<TreeNode> generateTrees(int n) {
        return circleGenerateTrees(1, n);
    }

    public List<TreeNode> circleGenerateTrees(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = circleGenerateTrees(start, i - 1);
            List<TreeNode> rights = circleGenerateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    nodes.add(currTree);
                }
            }
        }
        return nodes;
    }
}
