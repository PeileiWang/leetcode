/**
 * @author: wangpeilei
 * @date: 2021/04/08 23:30
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 **/
public class A2NodeAdd {
}

/**
 * 1、对齐链表
 * 2、进位预存
 * 3、前置节点保存
 */
class NodeAddSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode = new ListNode(0);

        ListNode cur = resultListNode;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            carry = sum / 10;
            int current = sum % 10;

            cur.next = new ListNode(current);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return resultListNode.next;
    }
}

class ListNode {
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
