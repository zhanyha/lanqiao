import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description 二分图——https://vjudge.net/problem/HihoCoder-1121
 * @Author zhanyuhao
 * @Date 2020/2/16 0:19
 **/
public class Main {
	static int n;
	static int[] vis ;//-1代表黑色，0代表未染，1为白色
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			que.clear();
			judge(sc);
		}
		sc.close();
	}

	private static void judge(Scanner sc) {
		n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][2];
		int[][] graph = new int[n][n];
		vis = new int[n];
		int p, r;
		for (int i = 0; i < m; i++) {
			p = sc.nextInt();
			r = sc.nextInt();
			if(p!=r) {
				graph[p - 1][r - 1] = 1;
				graph[r - 1][p - 1] = 1;
			}
		}
		vis[0]=1;//初始化 染成黑色
		que.add(0);//把节点加入队列
		if(bfs(graph)){
			System.out.println("Correct");
		}else{
			System.out.println("Wrong");
		}
	}

	private static boolean bfs(int[][] graph) {
		while(!que.isEmpty()) {
			int start=que.poll();//把最先加入的节点出队
			//找这个节点的邻居
			for (int i = 0; i < graph[start].length; i++) {
				if (graph[start][i] == 1 ) {//节点之间是连通的,
					if(vis[i] == 0) {//且无染色
						vis[i] = -(vis[start]);//染成不同的颜色
						graph[start][i]=0;
						graph[i][start]=0;//断开连接
						que.add(i);
					}else if(vis[i] == vis[start]){//这代表两个邻居颜色相同
						return false;
					}
				}
			}
		}
		return true;
	}
}