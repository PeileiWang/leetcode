package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/04/22 23:58
 **/
public class A21 {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     */

    public static class ListNode {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preNode = new ListNode();
            ListNode node = preNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            }

            if (l1 != null) {
                node.next = l1;
            }

            if (l2 != null) {
                node.next = l2;
            }

            return preNode.next;
        }
    }
}
