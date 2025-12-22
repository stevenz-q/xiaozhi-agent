package com.yqz.xiaozhi;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((n, m) -> m[1] - n[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            pq.add(new int[] {key, val});
        }
        return new int[1];
    }
}