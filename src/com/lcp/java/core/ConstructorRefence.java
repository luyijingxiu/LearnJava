package com.lcp.java.core;

import java.util.Arrays;
import java.util.List;

/**
 * 构造函数的数组参数不做克隆操作，可以通过修改外部引用改变
 * 构造出来的对象的数据
 *
 * @author buaaL
 */
public class ConstructorRefence {
    private List<Integer> list;

    public ConstructorRefence(List<Integer> list) {
        this.list = list;
    }

    public ConstructorRefence() {
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ConstructorRefence test = new ConstructorRefence(list);

        System.out.println("list[0]=" + list.get(0));
        System.out.println("test.list[0]=" + test.list.get(0));
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
