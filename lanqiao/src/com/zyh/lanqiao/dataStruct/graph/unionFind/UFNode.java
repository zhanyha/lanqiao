package com.zyh.lanqiao.dataStruct.graph.unionFind;

/**
 * @Description UFNode����
 * @Author zhanyuhao
 * @Date 2020/2/15 17:21
 **/
public class UFNode<T> {
    T value;
    UFNode parent;

    public UFNode(T value) {
        parent = this;//��parentָ���Լ�
        this.value = value;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
