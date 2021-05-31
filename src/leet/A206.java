package leet;

/**
 * @author: wangpeilei
 * @date: 2021/05/31 00:29
 **/
public class A206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode preNode = new ListNode();
            preNode.next = head;

            ListNode q = head.next;

            while (q != null) {
                ListNode p = preNode.next;

                ListNode qNext = q.next;

                preNode.next = q;
                head.next = q.next;
                q.next = p;

                q = qNext;
            }

            return preNode.next;
        }


        public ListNode reverseList2(ListNode head) {
            ListNode pre = null; //前指针节点
            ListNode cur = head; //当前指针节点

            //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
            while (cur != null) {
                ListNode next = cur.next; //临时节点，暂存当前节点的下一节点，用于后移
                cur.next = pre; //将当前节点指向它前面的节点
                pre = cur; //前指针后移
                cur = next; //当前指针后移
            }
            return pre;
        }

        // 递归
        public ListNode reverseList3(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode node = reverseList3(head.next);

            head.next.next = head;
            head.next = null;
            return node;
        }
    }


    public class ListNode {
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
