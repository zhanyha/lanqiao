package com.zyh.lanqiao.dataStruct.graph.HS;

import java.util.*;

/**
 * 说明：
 *     初始状态：随意
 *     最终状态：当二维数组里面的结果是 [[1,2,3],[4,5,6],[7,8,0]]。
 *     返回：最少移动的步数，怎么都不可能达到最终状态则返回-1
 *     其中数字 0 代表空格位置，它可以与周围的位置交换
 */
public class EightCodeBFS {
    public int moves;
    public long execTime;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//上，右，下，左四个方向
    private int[][] last = new int[][]{{1,2,3}, {4,5,6},{7,8,0}};
    private String target = Arrays.deepToString(last);//最终状态
    public int sliding(int[][] board) {
        moves = 0;
        long before = System.currentTimeMillis();
        int R = board.length;
        int C = board[0].length;
        int sr = 0, sc = 0; //开始搜索的起点，也就是0初始的位置
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;  //找到0 的位置后break

        Queue<Node> queue = new ArrayDeque();
        Node start = new Node(board, sr, sc, 0);
        queue.add(start);

        Set<String> seen = new HashSet();//存储已访问的状态
        seen.add(start.boardstring);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.boardstring.equals(target)) {
                long after = System.currentTimeMillis();
                execTime = after - before;
                return node.step;
            }

            for (int[] di: directions) {
                int nei_r = di[0] + node.zero_r;//下个位置的坐标
                int nei_c = di[1] + node.zero_c;
                //检查下一个位置是否可达
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;
                //交换位置
                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row: node.board)
                    newboard[t++] = row.clone();
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;
                moves++;
                Node nei = new Node(newboard, nei_r, nei_c, node.step+1);
                if (seen.contains(nei.boardstring))
                    continue;
                queue.add(nei);//加入队列
                seen.add(nei.boardstring);//加入已访问集合
            }
        }
        long after = System.currentTimeMillis();
        execTime = after - before;
        return -1;
    }

    private class Node {
        int[][] board;
        String boardstring;
        int zero_r;
        int zero_c;
        int step;
        Node(int[][] B, int r, int c, int s) {
            board = B;
            boardstring = Arrays.deepToString(board);
            zero_r = r;
            zero_c = c;
            step = s;
        }
    }
}
