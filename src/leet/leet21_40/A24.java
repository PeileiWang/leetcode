package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/11 22:16
 **/
public class A24 {

    private static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode preNode = new ListNode();

            preNode.next = head;

            ListNode curNode = preNode;

            while (curNode.next != null && curNode.next.next != null) {

                ListNode p = curNode.next;
                ListNode q = p.next;

                p.next = q.next;
                q.next = p;
                curNode.next = q;

                curNode = curNode.next.next;
            }

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
