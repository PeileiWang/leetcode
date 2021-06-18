package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/05/31 10:42
 **/
public class A61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        Solution solution = new Solution();
        solution.rotateRight(listNode, 2);
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

    private static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }
            int length = 1;
            ListNode tail = head;

            while (tail.next != null) {
                length++;
                tail = tail.next;
            }

            k %= length;
            if (k == 0) {
                return head;
            }

            // 找到倒数第k个节点的前驱结点
            ListNode p = new ListNode();
            p.next = head;
            ListNode cur = head;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
            }

            while (cur != null) {
                p = p.next;
                cur = cur.next;
            }

            ListNode res = p.next;
            tail.next = head;
            p.next = null;

            return res;
        }
    }
}
