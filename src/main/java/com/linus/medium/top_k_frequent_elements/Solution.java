package com.linus.medium.top_k_frequent_elements;

import java.util.*;

public class Solution {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> -((o1.getValue()).compareTo(o2.getValue())));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map = sortByValue(map);
        int number = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
            if (number < k) {
                result.add(entry.getKey());
                number++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 1, 1, 2, 2, 3, 4, 3, 3, 3, 5, 6, 8, 10, 11, 11, 11};
        System.out.println(new Solution().topKFrequent(test, 2));
    }
}
