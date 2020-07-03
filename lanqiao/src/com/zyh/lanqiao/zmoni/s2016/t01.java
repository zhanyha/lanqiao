package com.zyh.lanqiao.zmoni.s2016;

/**
 * @Description t01¡ª¡ª
 * @Author zhanyuhao
 * @Date 2020/4/11 12:37
 **/
public class t01 {
    public static void main(String[] args) {
        int res  =0 ;
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                res += j;
                if(res == 236) {
                    System.out.println(i +" "+j);
                    break;
                }
            }
            res = 0;
        }
        int yan=0;
        for (int i = 26; i <= 33; i++) {
            yan+=i;
        }
        System.out.println(yan);

    }
}
