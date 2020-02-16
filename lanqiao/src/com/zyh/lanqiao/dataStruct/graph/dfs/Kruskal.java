package com.zyh.lanqiao.dataStruct.graph.dfs;

import com.zyh.lanqiao.dataStruct.graph.Edge;
import com.zyh.lanqiao.dataStruct.graph.unionFind.UFNode;
import com.zyh.lanqiao.dataStruct.graph.unionFind.UnionFindSet;

import java.util.*;

/**
 * @Description Kruskal----��С��������һ���㷨
 * @Author zhanyuhao
 * @Date 2020/2/15 16:35
 **/
public class Kruskal {
    static List<Edge<String>> eds = new ArrayList<>();
    static List<Edge<String>> T = new ArrayList<>();
    static UnionFindSet uf = new UnionFindSet();
    static Map<String,UFNode<String>> map = new HashMap<>();//��ÿһ���ַ���Ӧ�ڵ㶼��ͬһ������Ϊ����һֱnew
    public static void main(String[] args) {
        Edge<String> e1 = new Edge<>("A","B",6);
        Edge<String> e2 = new Edge<>("A","C",1);
        Edge<String> e3 = new Edge<>("A","D",5);
        Edge<String> e5 = new Edge<>("B","C",5);
        Edge<String> e4 = new Edge<>("B","E",3);
        Edge<String> e6 = new Edge<>("C","E",6);
        Edge<String> e7 = new Edge<>("C","D",5);
        Edge<String> e8 = new Edge<>("C","F",4);
        Edge<String> e9 = new Edge<>("D","F",2);
        Edge<String> e10 = new Edge<>("E","F",6);
        eds.add(e1);eds.add(e2);eds.add(e3);eds.add(e4);eds.add(e5);
        eds.add(e6);eds.add(e7);eds.add(e8);eds.add(e9);eds.add(e10);
        for (Edge<String> e:eds) {//��ÿ����ͬ���ַ���Ӧһ���Ľڵ�
            map.put(e.start,new UFNode<>(e.start));
            map.put(e.end,new UFNode<>(e.end));
        }
        kruskal();
        for (Edge<String> e: T) {
            System.out.println(e);
        }
    }

    private static void kruskal() {
         //1.����
        Collections.sort(eds);
//        2.����ÿ��Ԫ��
        for (Edge<String> e: eds) {
            if(!ok(e))
                continue;
            T.add(e);
            if(T.size()+1==6){//��6���ڵ�
                return;
            }
        }
    }

    /**
     * ���ñ��Ƿ��ܼ��뵽T��
     * 1.���ñߵ����������Ƿ���ͬһ�����ϵ���
     * 2.���ǣ��򷵻�true����������Ԫ�ؼ��뵽ͬһ�����ϵ���
     *    �ǵĻ����򷵻�false
     * @return
     */
    private static boolean ok(Edge<String> e) {
        UFNode start = map.get(e.start);
        UFNode end = map.get(e.end);
        System.out.println(uf.find(start)+" == "+uf.find(end));
        if(uf.find(start) != UnionFindSet.find(end)){
            uf.union(start,end);
            return true;
        }
        return false;
    }
}
