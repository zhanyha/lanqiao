package com.zyh.lanqiao.dataStruct.graph.HS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * ˵����
 * ��ʼ״̬��ȫ�����г����п���
 * ����״̬������ά��������Ľ���� [[1,2,3],[4,5,6],[7,8,0]]��
 * ���أ������ƶ��Ĳ�������ô�������ܴﵽ����״̬�򷵻�-1
 * �������� 0 ����ո�λ�ã�����������Χ��λ�ý���
 */
public class EightCodeHS {
    public int moves;
    public long execTime;
    public int sliding(int[][] board) {
        moves = 0;
        long before = System.currentTimeMillis();
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;
//      �ҵ��ո��λ�ã������￪ʼ����
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;
        //�ĸ����򣬷ֱ����ϣ��ң��£��󡣣�˳ʱ�룩
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//        ʹ�����ȶ�������̬��ȡnode.depth + node.heuristic����Сֵ
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) ->
                (a.heuristic + a.depth) - (b.heuristic + b.depth));
        Node start = new Node(board, sr, sc, 0);
        heap.add(start);

        Map<String, Integer> cost = new HashMap();
        cost.put(start.boardstring, 9999999);
        //Ŀ��״̬
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
                //����Ƿ��ںϷ������棬Ҳ�����Ƿ�ν���
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row : node.board)
                    newboard[t++] = row.clone();

                // ����λ��
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;
                moves++;
                Node nei = new Node(newboard, nei_r, nei_c, node.depth + 1);
                if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
                    continue;
                heap.add(nei);
                //����F��ֵ F = nei.boardstring, nei.depth + nei.heuristic
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
