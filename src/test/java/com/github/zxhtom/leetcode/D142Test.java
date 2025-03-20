package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d142.D142;
import com.github.zxhtom.leetcode.d142.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author zxhtom
 * 2025/3/18
 */
public class D142Test extends BaseTest {
    ListNode listNode = new ListNode(1);
    List<ListNode> datas = new ArrayList<ListNode>(){
        {
            ListNode first = new ListNode(3);
            ListNode second = new ListNode(2);
            ListNode third = new ListNode(0);
            ListNode forth = new ListNode(-4);
            first.next = second;
            second.next = third;
            third.next = forth;
            forth.next = second;
            add(first);
        }
    };
    List<Integer> ans = new ArrayList<Integer>(){
        {
            add(1);
        }
    };
    @Before
    public void initData() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        second.next = first;
        datas.add(first);
        ans.add(0);

        ListNode first1 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        first1.next = second2;
        datas.add(first1);
        ans.add(-1);
    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends D142>> subTypesOf = getReflections().getSubTypesOf(D142.class);
        for (int i = 0; i < datas.size(); i++) {
            for (Class<? extends D142> clazz : subTypesOf) {
                D142 leetcode = clazz.newInstance();
                ListNode listNode = datas.get(i);
                ListNode resNode = leetcode.detectCycle(listNode);
                Integer pos = ans.get(i);
                if (pos < 0) {
                    listNode=null;
                }
                while (pos-- > 0) {
                    listNode = listNode.next;
                }
                Assert.assertTrue(resNode == listNode);
            }

        }
    }
}
