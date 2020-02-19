package com.zyh.lanqiao.dataStruct.graph.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q753_打开转盘锁 {

	public int openLock(String[] deadends, String target) {
		HashSet<String> deadSet = new HashSet<String>();
		for (String s : deadends)
			deadSet.add(s);
		if(deadSet.contains("0000"))  return -1;
		if (target.equals("0000"))  return 0;
		Map<String, Integer> visited = new HashMap<String, Integer>();
		Queue<String> que = new LinkedList<String>();
		String first = "0000";
		que.add(first);
		visited.put(first, 0);
		String poll;
		while (!que.isEmpty()) {
			poll = que.poll();
			//TODO:nexts
			for (String status : getNextStatus(poll)) {
				if (!deadSet.contains(status)) {
					if (!visited.containsKey(status)) {
						que.add(status);
						visited.put(status, visited.get(poll) + 1);
						if (status.equals(target)) {
							return visited.get(status);
						}
					}
				}
			}
		}
		return -1;
	}
	/**
	 * 更好的方法
	 * @param poll
	 * @return nexts
	 */
	private ArrayList<String> getNextStatus(String poll) {
		ArrayList<String> nexts =new ArrayList<String>();
		char[] charArray = poll.toCharArray();
		char o;
		for (int i = 0; i < 4; i++) {
			o = charArray[i];
			charArray[i] = Character.forDigit(( charArray[i]-'0'+1 )% 10, 10);
			nexts.add(new String(charArray));
			charArray[i]=o;
			
			charArray[i] = Character.forDigit(( charArray[i]-'0'+9 )% 10, 10);
			nexts.add(new String(charArray));
			charArray[i]=o;
		}
		return nexts;
	}
	private static String[] getNextStatus1(String poll) {
		String[] status = new String[8];
		for (int i = 0; i < 8; i += 2) {
			status[i] = poll.substring(0, i / 2)
					+ (Integer.parseInt(poll.substring(i / 2, i / 2 + 1)) + 1 == 10 ? 0
							: Integer.parseInt(poll.substring(i / 2, i / 2 + 1)) + 1)
					+ poll.substring(i / 2 + 1 >= 4 ? 4 : i / 2 + 1, 4);
			status[i + 1] = poll.substring(0, (i + 1) / 2)
					+ (Integer.parseInt(poll.substring((i + 1) / 2, (i + 1) / 2 + 1)) - 1 == -1 ? 9
							: Integer.parseInt(poll.substring((i + 1) / 2, (i + 1) / 2 + 1)) - 1)
					+ poll.substring((i + 1) / 2 + 1 >= 4 ? 4 : (i + 1) / 2 + 1, 4);
		}
		return status;
	}
}
