package com.zyh.lanqiao.dataStruct.graph.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q773_ª¨∂Ø√’Ã‚ {
	private boolean[] visited;
	private int[] depth;
	private int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int slidingPuzzle(int[][] board) {
		int f = boardToInt(board);
		if (f == 123450)
			return 0;
		visited = new boolean[654321];
		depth = new int[654321];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(f);
		visited[f] = true;
		depth[f] = 0;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			for (int w : nexts(poll))
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
					depth[w] = depth[poll] + 1;
					if (w == 123450) {
						return depth[w];
					}
				}
		}
		return -1;
	}

	private ArrayList<Integer> nexts(int poll) {
		ArrayList<Integer> nexts = new ArrayList<Integer>();
		int[][] board = new int[2][3];// 123450
		for (int i = 5; i >= 0; i--) {
			board[i / 3][i % 3] = poll % 10;
			poll /= 10;
		}
		int zero = 0;
		for (int i = 0; i < 6; i++) {
			if (board[i / 3][i % 3] == 0) {
				zero = i;
				break;
			}
		}
		int zx = zero / 3;
		int zy = zero % 3;
		for (int d = 0; d < 4; d++) {
			int nextx = zx + dirs[d][0];
			int nexty = zy + dirs[d][1];
			if (inArea(nextx, nexty)) {
				swap(board, zx, zy, nextx, nexty);
				nexts.add(boardToInt(board));
				swap(board, zx, zy, nextx, nexty);
			}
		}
		return nexts;
	}

	private void swap(int[][] board, int zx, int zy, int nextx, int nexty) {
		int tmp = board[zx][zy];
		board[zx][zy] = board[nextx][nexty];
		board[nextx][nexty] = tmp;
	}

	private boolean inArea(int nextx, int nexty) {
		return nextx >= 0 && nextx < 2 && nexty >= 0 && nexty < 3;
	}

	private int boardToInt(int[][] board) {
		int res = 0;
		for (int i = 1; i >= 0; i--)
			for (int j = 2; j >= 0; j--)
				res += board[i][j] * Math.pow(10, 5 - i * 3 - j);
		return res;
	}
}