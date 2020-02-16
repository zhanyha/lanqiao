import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description ����ͼ����https://vjudge.net/problem/HihoCoder-1121
 * @Author zhanyuhao
 * @Date 2020/2/16 0:19
 **/
public class Main {
	static int n;
	static int[] vis ;//-1�����ɫ��0����δȾ��1Ϊ��ɫ
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
		vis[0]=1;//��ʼ�� Ⱦ�ɺ�ɫ
		que.add(0);//�ѽڵ�������
		if(bfs(graph)){
			System.out.println("Correct");
		}else{
			System.out.println("Wrong");
		}
	}

	private static boolean bfs(int[][] graph) {
		while(!que.isEmpty()) {
			int start=que.poll();//�����ȼ���Ľڵ����
			//������ڵ���ھ�
			for (int i = 0; i < graph[start].length; i++) {
				if (graph[start][i] == 1 ) {//�ڵ�֮������ͨ��,
					if(vis[i] == 0) {//����Ⱦɫ
						vis[i] = -(vis[start]);//Ⱦ�ɲ�ͬ����ɫ
						graph[start][i]=0;
						graph[i][start]=0;//�Ͽ�����
						que.add(i);
					}else if(vis[i] == vis[start]){//����������ھ���ɫ��ͬ
						return false;
					}
				}
			}
		}
		return true;
	}
}