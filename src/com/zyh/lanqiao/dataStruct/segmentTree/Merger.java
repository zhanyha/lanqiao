package com.zyh.lanqiao.dataStruct.segmentTree;
/**
 * 该接口是为了为了使线段树更通用。
 * 当要求一段区间的和 ，merge的功能是 求 a+b
 * 当要求一段区间的积 ，merge的功能是 求 a*b
 * 也就是对于不同的业务，不需要重新修改SegmentTree的代码
* @author zhanyuhao
* @version 创建时间：2020年3月3日 下午9:57:45
* 类说明
 */
public interface Merger<E> {
	E merge(E a,E b);
}
