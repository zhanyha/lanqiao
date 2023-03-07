package com.zyh.lanqiao.dataStruct.graph.store;

/**
 * @Description Edge————图的存储节点，用来存储两个节点的值和边的权
 * @Author zhanyuhao
 * @Date 2020/2/15 16:48
 **/
public class Edge<T> implements Comparable<Edge<T>>{
    public T start;
    public T end;
    public Integer weight;//权
    public Edge(){}
    public Edge(T start, T end, Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return start +"----"+ end + ", weight=" + weight;
    }

    @Override
    public int compareTo(Edge<T> o) {
        return this.weight - o.weight;
    }
}
