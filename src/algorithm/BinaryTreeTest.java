package algorithm;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/**
 * @author: wangpeilei
 * @date: 2021/05/27 00:20
 **/
public class BinaryTreeTest {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode firstLeft = treeNode.left = new TreeNode(2);
        TreeNode firstRight = treeNode.right = new TreeNode(3);


        firstLeft.left = new TreeNode(4);
        firstLeft.right = new TreeNode(5);
        firstRight.left = new TreeNode(6);
        firstRight.right = new TreeNode(7);

        pre(treeNode);

        System.out.println();

        mid(treeNode);

        System.out.println();

        after(treeNode);


        System.out.println();
        System.out.println("----------------------");

        pre2(treeNode);
        System.out.println();

        mid2(treeNode);

        System.out.println();

        after2(treeNode);
    }

    //
    private static void pre(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            pre(treeNode.left);
            pre(treeNode.right);
        }
    }

    private static void mid(TreeNode treeNode) {
        if (treeNode != null) {
            mid(treeNode.left);
            System.out.print(treeNode.val + " ");
            mid(treeNode.right);
        }
    }

    private static void after(TreeNode treeNode) {
        if (treeNode != null) {
            after(treeNode.left);
            after(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    private static void pre2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    private static void mid2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = treeNode;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { // 将左一直入栈
                stack.push(cur);
                cur = cur.left;
            } else {
                // 没有左了，输出最底下的
                TreeNode pop = stack.pop();
                System.out.print(pop.val + " ");

                // 将最底下的右 赋给cur
                cur = pop.right;
            }
        }
    }

    private static void after2(TreeNode treeNode) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(treeNode);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);

            if (pop.left != null) {
                stack1.push(pop.left);
            }

            if (pop.right != null) {
                stack1.push(pop.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
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
