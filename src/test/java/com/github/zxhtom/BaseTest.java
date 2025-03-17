package com.github.zxhtom;

import org.reflections.Reflections;

import java.util.List;
import java.util.Set;

/**
 * @author zxhtom
 * 2025/3/17
 */
public class BaseTest {
    private Reflections reflections = new Reflections("com.github.zxhtom");


    public Reflections getReflections() {
        return reflections;
    }

    public void setReflections(Reflections reflections) {
        this.reflections = reflections;
    }
}
