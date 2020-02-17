package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description GraphNode_NL——邻接矩阵的节点
 * @Author zhanyuhao
 * @Date 2020/2/15 16:38
 **/
public class GraphNode_NL<T> {
    private T value;
    private List<GraphNode_NL<T>> neighbors;
    public GraphNode_NL(){}
    public GraphNode_NL(T value) {
        this.value = value;
    }

    public GraphNode_NL getNeighbor(int i){
        return neighbors.get(i);
    }
    public void add(GraphNode_NL node){
        if(this.neighbors==null){
            neighbors = new ArrayList<>();
        }
        neighbors.add(node);
    }
}
