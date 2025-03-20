package com.github.zxhtom.leetcode.d142.impl;

import com.github.zxhtom.leetcode.d142.D142;
import com.github.zxhtom.leetcode.d142.ListNode;

/**
 * @author zxhtom
 * 2025/3/18
 */
public class D142Impl implements D142 {
    @Override
    public ListNode detectCycle(ListNode head) {
        ListNode turtle = head, rabbit=head;
        int index = 0;
        while (turtle != null && turtle.next != null && rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                break;
            }
        }
        ListNode ptr = head;
        while (turtle != null && turtle.next != null && rabbit.next != null && rabbit.next.next != null) {
            if (ptr == turtle) {
                return ptr;
            }
            ptr = ptr.next;
            turtle = turtle.next;
        }
        return null;
    }
}
