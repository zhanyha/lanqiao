package com.zyh.lanqiao.zmoni.s2016;

/**
 * @Description t03¡ª¡ª
 * @Author zhanyuhao
 * @Date 2020/4/11 12:37
 **/
public class t03 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        full(0, arr);
        System.out.println(cnt);
    }

    static int cnt = 0;

    private static void full(int cur, int[] arr) {
        if (cur == arr.length) {
            if (check(arr)) {
                cnt++;
            }
        }
        for (int i = cur; i < arr.length; i++) {
            swap(arr, cur, i);
            full(cur + 1, arr);
            swap(arr, cur, i);
        }
    }

    private static boolean check(int[] arr) {
        return arr[0] < arr[1] && arr[0] < arr[2] && arr[1] < arr[3] && arr[1] < arr[4]
                && arr[2] < arr[4] && arr[2] < arr[5] && arr[3] < arr[6] && arr[3] < arr[7]
                && arr[4] < arr[7] && arr[4] < arr[8] && arr[5] < arr[8] && arr[5] < arr[9];
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
