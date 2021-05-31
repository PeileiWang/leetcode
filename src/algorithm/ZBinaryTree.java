package algorithm;

import java.util.*;

/**
 * @author: wangpeilei
 * @date: 2021/05/23 18:10
 **/
public class ZBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode firstLeft = treeNode.left = new TreeNode(2);
        TreeNode firstRight = treeNode.right = new TreeNode(3);


        firstLeft.left = new TreeNode(4);
        firstLeft.right = new TreeNode(5);
        firstRight.left = new TreeNode(6);
        firstRight.right = new TreeNode(7);

        firstLeft.left.left = new TreeNode(8);
        firstLeft.left.right = new TreeNode(9);
        firstLeft.right.left = new TreeNode(10);
        firstLeft.right.right = new TreeNode(11);

        firstRight.left.left = new TreeNode(12);
        firstRight.left.right = new TreeNode(13);
        firstRight.right.left = new TreeNode(14);
        firstRight.right.right = new TreeNode(15);


        bfs(treeNode);
    }

    private static void bfs(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(treeNode);

        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<TreeNode> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val);

                if (reverse) {
                    if (cur.right != null) {
                        tempList.add(cur.right);
                    }

                    if (cur.left != null) {
                        tempList.add(cur.left);
                    }
                } else {
                    if (cur.left != null) {
                        tempList.add(cur.left);
                    }

                    if (cur.right != null) {
                        tempList.add(cur.right);
                    }
                }
            }

            for (int i = tempList.size() - 1; i >= 0; i--) {
                queue.offer(tempList.get(i));
            }

            reverse = !reverse;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
