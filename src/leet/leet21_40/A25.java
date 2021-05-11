package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/11 22:33
 **/
public class A25 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        solution.reverseKGroup(listNode, 4);

        System.out.println(listNode);
    }

    private static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode preNode = new ListNode();
            preNode.next = head;

            ListNode cur = preNode;

            if (k == 1) {
                return preNode.next;
            }

            ListNode[] listNodes = new ListNode[k];

            while (cur.next != null) {

                ListNode temp = cur.next;
                for (int i = 0; i < k; i++) {
                    if (temp != null) {
                        listNodes[i] = temp;
                        temp = temp.next;
                    } else {
                        return preNode.next;
                    }
                }

                int left = 0;
                int right = k - 1;

                ListNode temp1 = cur;
                while (left < right) {
                    ListNode p = listNodes[left];
                    ListNode q = listNodes[right];
                    ListNode r = listNodes[left + 1];
                    ListNode s = listNodes[right - 1];

                    p.next = q.next;
                    if (right - left != 1) {
                        s.next = p;
                        q.next = r;
                    } else {
                        q.next = p;
                    }
                    temp1.next = q;
                    temp1 = temp1.next;
                    left++;
                    right--;
                }

                for (int i = 0; i < k; i++) {
                    cur = cur.next;
                }
            }

            return preNode.next;
        }
    }

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
}
