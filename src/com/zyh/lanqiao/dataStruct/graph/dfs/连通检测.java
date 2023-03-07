package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Scanner;

/**
 * 给定一个方阵，定义连通：上下左右相邻，并且值相同
 * 输入：
整数N, (N<50)表示矩阵的行列数
接下来N行，每行N个字符，代表方阵中的元素
接下来一个整数M，(M<1000)表示询问数
接下来M行，每行代表一个询问，
格式为4个整数，y1,x1,y2,x2，
表示询问(第y1行,第x1列) 与 (第y2行,第x2列) 是否连通。
连通输出true，否则false

例如：
10
0010000000
0011100000
0000111110
0001100010
1111010010
0000010010
0000010011
0111111000
0000010000
0000000000
3
0 0 9 9
0 2 6 8
4 4 4 6
程序应该输出：
false
true
true
* @author zhanyuhao
* @version 创建时间：2020年2月14日 下午8:49:01
* 类说明
 */
public class 连通检测 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();sc.nextLine();
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		int m = sc.nextInt();
		int[][] pos = new int[m][4];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++) {
				pos[i][j] = sc.nextInt();
			}
			boolean bool = dfs(arr,pos[i]);
			System.out.println(bool);
		}
		
		sc.close();
	}
	private static boolean dfs(char[][] arr,int[] pos) {
		int x1 = pos[0];
		int y1 = pos[1];
		int x2 = pos[2];
		int y2 = pos[3];
		if(x1==x2&&y1==y2) return true;
		int label = arr[x1][y1];
		boolean b1 = false,b2 = false,b3 = false,b4 = false;;
		if(x1-1>=0&&arr[x1-1][y1]==label) {//没有越界  //数字相同
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[0]-=1;//上
			b1 = dfs(arr,pos);
			pos[0]+=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(y1+1<arr.length&&arr[x1][y1+1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[1]+=1;//右
			b2 = dfs(arr,pos);
			pos[1]-=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(x1+1<arr.length&&arr[x1+1][y1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[0]+=1;//下
			b3 = dfs(arr,pos);
			pos[0]-=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(y1-1>=0&&arr[x1][y1-1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[1]-=1;//左
			b4 = dfs(arr,pos);
			pos[1]+=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		return b1||b2||b3||b4;
	}
}
