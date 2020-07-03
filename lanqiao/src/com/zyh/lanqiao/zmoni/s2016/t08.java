package com.zyh.lanqiao.zmoni.s2016;

import java.util.Scanner;

public class t08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] qu = new int[3];
        for (int i = 0; i < 3; i++) {
            qu[i] = sc.nextInt();
        }
        int[] d = new int[5];
        for (int i = 0; i < 5; i++) {
            d[i] = sc.nextInt();
        }
        work(qu, d);

    }

    private static void work(int[] qu, int[] d) {
        for (int i = 0; i < 5; i++) {
            System.out.println(dfs(d[i], qu, 0, 0));
        }
    }

    private static int dfs(int n, int[] qu, int a, int b) {
        if (n == 0) {
            if (a % 2 != 0) {
                if (b % 2 == 0)
                    return 1;
                return 0;
            }
            if (b % 2 != 0)
                return -1;
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if(n - qu[i] >= 0) {
                res = dfs(n - qu[i], qu, b, a + qu[i]);
            }
        }
        return res;
    }


}
