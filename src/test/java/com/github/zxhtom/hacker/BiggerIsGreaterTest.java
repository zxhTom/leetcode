package com.github.zxhtom.hacker;

import com.github.zxhtom.hacker.BiggerIsGreater.impl.BiggerIsGreater;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/3/14
 */
public class BiggerIsGreaterTest {
    List<String> datas = new ArrayList<String>(){
        {
            add("lchmvizvnkxaucmdbzsjtqlpda");
            add("kwkjxiiwinkodswdemvnpsoexjzujupseacgqsbhqfdngxuhzpqmwcvioifinnkngphbtgrareb");
            add("yricnue");
            add("ibqckpqniuyo");
            add("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw");
            add("dkhc");
            add("abcd");
            add("ba");
        }
    };
    List<String> ans = new ArrayList<String>(){
        {
            add("lchmvizvnkxaucmdbzsjtqpadl");
            add("kwkjxiiwinkodswdemvnpsoexjzujupseacgqsbhqfdngxuhzpqmwcvioifinnkngphbtgrbaer");
            add("yricuen");
            add("ibqckpqniyou");
            add("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm");
            add("hcdk");
            add("abdc");
            add("no answer");
        }
    };

    @Before
    public void initData() {

    }
    @Test
    public void simpleTest() {
        for (int i = 0; i < datas.size(); i++) {
            String res = BiggerIsGreater.biggerIsGreater(datas.get(i));
            System.out.println("i = " + i);
            Assert.assertTrue(res.equals(ans.get(i)));
        }
    }
}

