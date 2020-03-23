import com.zyh.lanqiao.dataStruct.graph.HS.EightCodeBFS;
import com.zyh.lanqiao.dataStruct.graph.HS.EightCodeHS;

public class Main {
    private static int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    private static EightCodeBFS eightCodeBFS;//广度优先搜索
    private static EightCodeHS eightCodeHS;//启发式搜索

    public static void main(String[] args) {
        eightCodeBFS = new EightCodeBFS();
        eightCodeHS = new EightCodeHS();
        fullPermutation(board, 0);
    }

    //列出所有可能
    private static void fullPermutation(int[][] board, int cur) {
        if (cur == 9) {
            eightCodeBFS.sliding(board);
            int step = eightCodeHS.sliding(board);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println("  最少移动步数:"+step);
            System.out.println(String.format("  BFS搜索的试探步数: %d,执行时间：%dms", eightCodeBFS.moves,eightCodeBFS.execTime));
            System.out.println(String.format("  HS搜索的试探步数: %d,执行时间：%dms", eightCodeHS.moves,eightCodeHS.execTime));
        }
        for (int i = cur; i <= 8; i++) {
            int t = board[cur / 3][cur % 3];
            board[cur / 3][cur % 3] = board[i / 3][i % 3];
            board[i / 3][i % 3] = t;
            fullPermutation(board, cur + 1);
            t = board[cur / 3][cur % 3];
            board[cur / 3][cur % 3] = board[i / 3][i % 3];
            board[i / 3][i % 3] = t;
        }
    }

}