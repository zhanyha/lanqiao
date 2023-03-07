package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Scanner;

/**
 * ����һ�����󣬶�����ͨ�������������ڣ�����ֵ��ͬ
 * ���룺
����N, (N<50)��ʾ�����������
������N�У�ÿ��N���ַ����������е�Ԫ��
������һ������M��(M<1000)��ʾѯ����
������M�У�ÿ�д���һ��ѯ�ʣ�
��ʽΪ4��������y1,x1,y2,x2��
��ʾѯ��(��y1��,��x1��) �� (��y2��,��x2��) �Ƿ���ͨ��
��ͨ���true������false

���磺
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
����Ӧ�������
false
true
true
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��14�� ����8:49:01
* ��˵��
 */
public class ��ͨ��� {
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
		if(x1-1>=0&&arr[x1-1][y1]==label) {//û��Խ��  //������ͬ
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[0]-=1;//��
			b1 = dfs(arr,pos);
			pos[0]+=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(y1+1<arr.length&&arr[x1][y1+1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[1]+=1;//��
			b2 = dfs(arr,pos);
			pos[1]-=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(x1+1<arr.length&&arr[x1+1][y1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[0]+=1;//��
			b3 = dfs(arr,pos);
			pos[0]-=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		if(y1-1>=0&&arr[x1][y1-1]==label) {
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
			pos[1]-=1;//��
			b4 = dfs(arr,pos);
			pos[1]+=1;
			arr[x1][y1]=arr[x1][y1]=='1'?'0':'1';
		}
		return b1||b2||b3||b4;
	}
}
