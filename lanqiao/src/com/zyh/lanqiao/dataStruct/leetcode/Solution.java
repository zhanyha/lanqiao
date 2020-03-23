package com.zyh.lanqiao.dataStruct.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int num : nums)
			if (map.get(num) == null) {
				map.put(num, 1);
			} else
				map.put(num, map.get(num) + 1);

		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Queue<Integer> pq = new PriorityQueue<Integer>(
				(a, b) -> map.get(a) - map.get(b)
		);

		for (Entry<Integer, Integer> e : entrySet) {
			if (pq.size() < k) {
				pq.add(e.getKey());
			} else if (e.getValue() > map.get(pq.peek())) {
				pq.remove();
				pq.add(e.getKey());
			}
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			res.add(pq.remove());
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 0, 1, 0 };
		int k = 1;
		new Solution().topKFrequent(nums, k);
	}
}
