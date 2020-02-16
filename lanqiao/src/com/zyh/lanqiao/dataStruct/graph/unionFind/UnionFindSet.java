package com.zyh.lanqiao.dataStruct.graph.unionFind;

import java.util.HashSet;

/**
 * @Description UnionFindSet——并查集的简单实现
 * @Author zhanyuhao
 * @Date 2020/2/15 17:19
 **/
public class UnionFindSet {
    public static UFNode find(UFNode x){
        UFNode p = x;
        HashSet<UFNode> set = new HashSet<UFNode>();
        while(p!=p.parent){
            set.add(p);
            p = p.parent;
        }
        for (UFNode n : set) {
            n.parent = p;
        }
        return p;
    }
    public static void union(UFNode x,UFNode y){
        find(y).parent = find(x);
    }
}
