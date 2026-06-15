package com.tzih.learn.daily;

public class L2095 {
    public ListNode deleteMiddle(ListNode head) {
        //快指针每次走 2步，慢指针走 1步,额外用一前驱指针跟着慢指针，删除慢指针指向的中间节点
        //快指针走到末尾时，慢指针恰好停在中间节点，前驱指针指向中间节点的前一个节点
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        //快指针没走到末尾就继续遍历
        while (fast != null && fast.next != null) {
            pre = slow; //向前走一步
            slow = slow.next;
            fast = fast.next.next; //走两步
        }

        //前驱指针向前走两步跳过slow所指节点（即中间节点）
        pre.next = slow.next;
        return head;

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
