package com.zyh.lanqiao.dataStruct.graph.HS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 说明：
 * 初始状态：全排列列出所有可能
 * 最终状态：当二维数组里面的结果是 [[1,2,3],[4,5,6],[7,8,0]]。
 * 返回：最少移动的步数，怎么都不可能达到最终状态则返回-1
 * 其中数字 0 代表空格位置，它可以与周围的位置交换
 */
public class EightCodeHS {
    public int moves;
    public long execTime;
    public int sliding(int[][] board) {
        moves = 0;
        long before = System.currentTimeMillis();
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;
//      找到空格的位置，从这里开始搜索
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;
        //四个方向，分别是上，右，下，左。（顺时针）
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//        使用优先队列来动态获取node.depth + node.heuristic的最小值
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) ->
                (a.heuristic + a.depth) - (b.heuristic + b.depth));
        Node start = new Node(board, sr, sc, 0);
        heap.add(start);

        Map<String, Integer> cost = new HashMap();
        cost.put(start.boardstring, 9999999);
        //目标状态
        String target = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.boardstring.equals(target)) {
                long after = System.currentTimeMillis();
                execTime = after - before;
                return node.depth;
            }
            if (node.depth + node.heuristic > cost.get(node.boardstring))
                continue;

            for (int[] di : directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;
                //检查是否在合法域里面，也就是是否课交换
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row : node.board)
                    newboard[t++] = row.clone();

                // 交换位置
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;
                moves++;
                Node nei = new Node(newboard, nei_r, nei_c, node.depth + 1);
                if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
                    continue;
                heap.add(nei);
                //更新F的值 F = nei.boardstring, nei.depth + nei.heuristic
                cost.put(nei.boardstring, nei.depth + nei.heuristic);
            }
        }
        long after = System.currentTimeMillis();
        execTime = after - before;
        return -1;
    }
    private class Node {
        int[][] board;
        String boardstring;
        int heuristic;
        int zero_r;
        int zero_c;
        int depth;

        Node(int[][] B, int zr, int zc, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);

            //Calculate heuristic
            heuristic = 0;
            int R = B.length, C = B[0].length;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    if (board[r][c] == 0) continue;
                    int v = (board[r][c] + R * C - 1) % (R * C);
                    // v/C, v%C: where board[r][c] should go in a solved puzzle
                    heuristic += Math.abs(r - v / C) + Math.abs(c - v % C);
                }
            heuristic /= 2;
            zero_r = zr;
            zero_c = zc;
            depth = d;
        }
    }
}
