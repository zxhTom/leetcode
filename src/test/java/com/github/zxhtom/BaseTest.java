package com.github.zxhtom;

import com.github.zxhtom.annotaions.Ignore;
import org.reflections.Reflections;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zxhtom
 * 2025/3/17
 */
public class BaseTest {
    private Reflections reflections = new Reflections("com.github.zxhtom");


    public Reflections getReflections() {
        return reflections;
    }

    public <T> Set<Class<? extends T>> getSubTypesOf(Class<T> clazz) {
        Set<Class<? extends T>> subTypesOf = this.reflections.getSubTypesOf(clazz);
        return subTypesOf.stream().filter(item -> {
            return !item.isAnnotationPresent(Ignore.class);
        }).collect(Collectors.toSet());
    }
    public void setReflections(Reflections reflections) {
        this.reflections = reflections;
    }
}
