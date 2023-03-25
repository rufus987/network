package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Inter1> list = new ArrayList<>();
        Impl1 impl1 = new Impl1();
        Impl2 impl2 = new Impl2();
        list.add(impl1);
        list.add(impl2);
        list.add(impl1);
        for (Inter1 inter1 : list) {
            inter1.method();
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hdfhfdh");
        map.put(43, "hhdfkdk");
        map.put(89, "sddsdsds");
        Collection<String> values = map.values();   //alt+enter
        for (String value : values) {
            System.out.println(value); //iter
        }

    }
}