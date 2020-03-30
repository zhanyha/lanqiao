import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int R;
    int C;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int[][] depth;

    public int maxDistance(int[][] grid) {
        this.R = grid.length;
        this.C = grid[0].length;
        if (check(grid, R, C)) {
            return -1;
        }
        depth = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    visited = new boolean[R][C];
                    bfs(grid, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max = Math.max(max,depth[i][j]);
            }
        }
        return max;
    }

    private void bfs(int[][] grid, int x, int y) {
        visited[x][y] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(x * C + y);
        while (!que.isEmpty()) {
            int poll = que.remove();
            x = poll / C;
            y = poll % C;
            for (int d = 0; d < 4; d++) {
                int nextx = x + dirs[d][0];
                int nexty = y + dirs[d][1];
                if (inArea(nextx, nexty) && grid[nextx][nexty] == 0 && !visited[nextx][nexty]) {
                    visited[nextx][nexty] = true;
                    depth[nextx][nexty] = Math.min(depth[nextx][nexty] == 0 ? 9999 : depth[nextx][nexty], depth[x][y] + 1);
                    que.add(nextx * C + nexty);
                }
            }
        }
    }

    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < C;
    }

    private boolean check(int[][] grid, int r, int c) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else
                    oneCount++;
            }
        }
        return zeroCount == 0 || oneCount == 0;
    }

    public static void main(String[] args) {
        int[][] gird = {{1, 0, 1}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(new Solution().maxDistance(gird));
    }
}