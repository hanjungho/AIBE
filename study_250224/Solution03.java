package Devcos.AIBE.study_250224;

import java.util.*;

public class Solution03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("Python");
        list.add("JS");
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

        Map<String, Integer> map = new HashMap<>();
        map.put("자바", 100);
        map.put("파이썬", 200);
        System.out.println("map = " + map);
        System.out.println("map.size() = " + map.size());

        Set<String> set = new HashSet<>();
        set.add("자바");
        set.add("자바");
        set.add("자바");
        set.add("자바");
        set.add("자바");
        set.add("자바");
        set.add("자바");
        System.out.println("set = " + set);
        System.out.println("set.size() = " + set.size());
    }
}
