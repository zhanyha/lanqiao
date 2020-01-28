package com.zyh.lanqiao.dfs;

import java.util.Scanner;
//12 10
//W*******WW
//*WW*****W*
//**WW****W*
//**WWW***W*
//********WW
//********WW
//**W*****WW
//*WWW****WW
//WWWWW***W*
//WWWWW***W*
//*WWW*****W
//**W******W
public class 问题3_水洼数目 {
	static int N;
	static int M;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();sc.nextLine();
		char[][] a = new char[N][M];
		for (int i = 0; i < N; i++) {
			 a[i] = sc.nextLine().toCharArray();
		}
		while(true) {
			int[] pos = findWater(a);//x,y坐标
			if(pos == null) {
				break;
			}
			dfs(a,pos[0],pos[1]);
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

	private static void dfs(char[][] a, int x, int y) {
		if(a[x][y] == 'W') {
			a[x][y] = '*';
			for (int i = -1; i < 2; i++) {//-1 0 1
				for (int j = -1; j < 2; j++) { // -1 0 1
					if(i==0 && j==0) //排除自身，剩下的就是8个方向
						continue;
					if(x+i>=0 && y+j>=0 && x+i<N && y+j < M) {
						dfs(a,x+i,y+j);
					}
				}
			}
		}
		
	}
	private static int[] findWater(char[][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(a[i][j] == 'W') {
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

}
