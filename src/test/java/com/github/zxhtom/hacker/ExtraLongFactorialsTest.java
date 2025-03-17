package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.ExtraLongFactorials.impl.ExtraLongFactorials;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/8
 */
public class ExtraLongFactorialsTest {
    List<Integer> data = new ArrayList<Integer>() {{
        add(25);
    }};
    List<String> ans = new LinkedList<String>(){{
        add("15511210043330985984000000");
    }};
    @Before
    public void initTestData() {

    }

    @Test
    public void simpleTest(){
        // 创建 ByteArrayOutputStream 来捕获输出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // 保存原来的 System.out
        PrintStream originalOut = System.out;
        for (int i = 0; i < data.size(); i++) {
            Integer datum = data.get(i);
            // 重定向 System.out 到 ByteArrayOutputStream
            System.setOut(ps);
            ExtraLongFactorials.extraLongFactorials(datum);
            // 恢复原来的 System.out
            System.setOut(originalOut);
            // 获取捕获的输出内容
            String capturedOutput = baos.toString();
            Assert.assertTrue(capturedOutput.equals(ans.get(i)));

        }
    }
}
