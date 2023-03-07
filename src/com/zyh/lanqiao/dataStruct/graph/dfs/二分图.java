package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 二分图——DFS实现代码,图的存储采用邻接表
 * @Author zhanyuhao
 * @Date 2020/2/16 13:53
 **/
public class 二分图 {
    private static class Node<T> {
        int color;
        T value;
        private List<Node<T>> neighbors;

        public Node(T value) {
            this.value = value;
        }

        public void add(Node node) {
            if (this.neighbors == null) {
                neighbors = new ArrayList<>();
            }
            neighbors.add(node);
        }
    }

    static List<Node<Integer>> nl = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            nl.clear();
            judge(sc);
        }
        sc.close();
    }

    private static void judge(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p, r;
        for (int i = 0; i < n; i++) {
            nl.add(new Node<>(i + 1));
        }
        for (int i = 0; i < m; i++) {
            p = sc.nextInt();
            r = sc.nextInt();
            if(p!=r) {
                nl.get(p - 1).add(nl.get(r - 1));
                nl.get(r - 1).add(nl.get(p - 1));
            }
        }
        nl.get(0).color = 1;//黑色
        if (dfs(0)) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }
    }

    private static boolean dfs(int start) {
        List<Node<Integer>> ns = nl.get(start).neighbors;
        if(ns==null) return true;
        for (int i = 0; i < ns.size(); i++) {
            if (ns.get(i).color == nl.get(start).color) return false;
            if(ns.get(i).color==0) {
                ns.get(i).color = -(nl.get(start).color);
                boolean b = dfs(ns.get(i).value-1);
                if (!b) {
                    return false;
                }
            }
        }
        return true;
    }
}
//1
//5 6
//1 2
//1 5
//2 3
//2 4
//3 5
//4 5
