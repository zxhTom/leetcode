package com.github.zxhtom.leetcode;

import com.github.zxhtom.BaseTest;
import com.github.zxhtom.leetcode.d95.D95;
import com.github.zxhtom.leetcode.d95.TreeNode;
import com.github.zxhtom.leetcode.d95.impl.D95_Standout_And_Check_Self_Rights;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/11
 */
public class D95Test extends BaseTest {
    List<Integer> datas = new ArrayList<Integer>(){
        {
            add(3);
            add(1);
        }
    };
    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() throws InstantiationException, IllegalAccessException {
        D95_Standout_And_Check_Self_Rights ans = new D95_Standout_And_Check_Self_Rights();
        for (Integer i : datas) {
            List<TreeNode> answer = ans.generateTrees(i);
            for (Class<? extends D95> clazz : getSubTypesOf(D95.class)) {
                D95 leetcode = clazz.newInstance();
                List<TreeNode> treeNodes = leetcode.generateTrees(i);

            }
        }
    }
}
