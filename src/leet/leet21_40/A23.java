package leet.leet21_40;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: wangpeilei
 * @date: 2021/04/24 20:39
 **/
public class A23 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = node1;
        listNodes[1] = node2;
        listNodes[2] = node3;

        ListNode listNode = solution.mergeKLists(listNodes);

        System.out.println(1);
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
        public ListNode mergeKLists(ListNode[] lists) {
            int length = lists.length;

            return helper(lists, 0, length - 1);
        }

        private ListNode helper(ListNode[] lists, int left, int right) {

            // 左右合到一起了
            if (left == right) {
                return lists[left];
            }

            // 左大于右了
            if (left > right) {
                return null;
            }

            int mid = (right + left) / 2;
            ListNode listNode1 = helper(lists, left, mid);
            ListNode listNode2 = helper(lists, mid + 1, right);
            return merge(listNode1, listNode2);
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }
            ListNode pre = new ListNode();
            ListNode cur = pre;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            while (list1 != null) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }

            while (list2 != null) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }

            return pre.next;
        }


        public ListNode mergeKListsV2(ListNode[] lists) {
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            // 先都加到队列里
            for (ListNode node : lists) {
                if (node != null) {
                    priorityQueue.offer(node);
                }
            }

            ListNode pre = new ListNode();
            ListNode cur = pre;

            while (!priorityQueue.isEmpty()) {
                ListNode poll = priorityQueue.poll();

                cur.next = poll;
                cur = cur.next;

                if (poll.next != null) {
                    priorityQueue.offer(poll.next);
                }
            }

            return pre.next;
        }
    }
}
