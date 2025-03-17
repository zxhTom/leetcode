package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.Encryption.impl.Encryption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/12
 */
public class EncryptionTest {
    List<String> datas = new ArrayList<String>(){
        {
            add("feedthedog");
            add("haveaniceday");
        }
    };
    List<String> ans = new ArrayList<String>(){
        {
            add("fto ehg ee dd");
            add("hae and via ecy");
        }
    };

    @Before
    public void initData() {

    }

    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            String encryption = Encryption.encryption(datas.get(i));
            System.out.println("i = " + i);
            Assert.assertTrue(encryption.equals(ans.get(i)));
        }
    }
}
