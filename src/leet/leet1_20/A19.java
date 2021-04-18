package leet.leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/14 23:35
 **/
public class A19 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // 定义head的前置节点
            ListNode preNode = new ListNode();
            preNode.next = head;

            // 删除节点的前一节点
            ListNode delPreNode = preNode;

            // 先走n步的节点
            ListNode movePre = preNode;

            // movePre先走n步
            for (int i = 0; i < n; i++) {
                movePre = movePre.next;
            }

            // 到movePre为空时，此时也即找到了delPreNode
            while (movePre.next != null) {
                movePre = movePre.next;
                delPreNode = delPreNode.next;
            }

            ListNode delNode = delPreNode.next;

            delPreNode.next = delNode.next;

            return preNode.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


