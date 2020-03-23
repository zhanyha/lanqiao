package com.zyh.lanqiao.dataStruct.graph.HS;

import java.util.*;

/**
 * ˵����
 *     ��ʼ״̬������
 *     ����״̬������ά��������Ľ���� [[1,2,3],[4,5,6],[7,8,0]]��
 *     ���أ������ƶ��Ĳ�������ô�������ܴﵽ����״̬�򷵻�-1
 *     �������� 0 ����ո�λ�ã�����������Χ��λ�ý���
 */
public class EightCodeBFS {
    public int moves;
    public long execTime;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//�ϣ��ң��£����ĸ�����
    private int[][] last = new int[][]{{1,2,3}, {4,5,6},{7,8,0}};
    private String target = Arrays.deepToString(last);//����״̬
    public int sliding(int[][] board) {
        moves = 0;
        long before = System.currentTimeMillis();
        int R = board.length;
        int C = board[0].length;
        int sr = 0, sc = 0; //��ʼ��������㣬Ҳ����0��ʼ��λ��
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;  //�ҵ�0 ��λ�ú�break

        Queue<Node> queue = new ArrayDeque();
        Node start = new Node(board, sr, sc, 0);
        queue.add(start);

        Set<String> seen = new HashSet();//�洢�ѷ��ʵ�״̬
        seen.add(start.boardstring);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.boardstring.equals(target)) {
                long after = System.currentTimeMillis();
                execTime = after - before;
                return node.step;
            }

            for (int[] di: directions) {
                int nei_r = di[0] + node.zero_r;//�¸�λ�õ�����
                int nei_c = di[1] + node.zero_c;
                //�����һ��λ���Ƿ�ɴ�
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;
                //����λ��
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
                queue.add(nei);//�������
                seen.add(nei.boardstring);//�����ѷ��ʼ���
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
