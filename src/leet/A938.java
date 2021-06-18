package leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangpeilei
 * @date: 2021/04/27 23:43
 **/
public class A938 {

    /**
     * Definition for a binary tree node.
     */

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public int rangeSumBST_BFS(TreeNode root, int low, int high) {
            Queue<TreeNode> queue = new LinkedList<>();

            if (root == null) {
                return 0;
            }

            queue.offer(root);

            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.val >= low && treeNode.val <= high) {
                        sum += treeNode.val;
                    }

                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
            }

            return sum;
        }

        public int rangeSumBST_DFS(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            if (root.val > high) {
                return rangeSumBST_DFS(root.left, low, high);
            }

            if (root.val < low) {
                return rangeSumBST_DFS(root.right, low, high);
            }

            return root.val + rangeSumBST_DFS(root.left, low, high) + rangeSumBST_DFS(root.right, low, high);
        }
    }
}
