package com.zyh.lanqiao.zmoni.s2016;

import java.util.ArrayList;
import java.util.Arrays;

public class t06 {
    static int count;
    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < 12; i++) {
            arr[i] = i + 1;
        }
        for (int i = 13; i >= 2; i--) {
            full(arr,0);
            arr[i-2] = i;
        }
        System.out.println(count);
    }

    private static void full(int[] arr, int cur) {
        if(cur == arr.length){
            if(check(arr)){
                System.out.println(Arrays.toString(arr));
                count++;
            }
        }
        for (int i = cur; i < arr.length; i++) {
            int t = arr[cur];
            arr[cur] = arr[i];
            arr[i] = t;
            full(arr,cur+1);
            t = arr[cur];
            arr[cur] = arr[i];
            arr[i] = t;
        }
    }

    private static boolean check(int[] arr) {
        return arr[0] + arr[1] == arr[2]
                && arr[3] - arr[4] == arr[5]
                && arr[6] * arr[7] == arr[8]
                && arr[10] * arr[11] == arr[9];
    }
}
