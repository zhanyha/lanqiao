package com.zyh.lanqiao.dataStruct.segmentTree;
/**
 * �ýӿ���Ϊ��Ϊ��ʹ�߶�����ͨ�á�
 * ��Ҫ��һ������ĺ� ��merge�Ĺ����� �� a+b
 * ��Ҫ��һ������Ļ� ��merge�Ĺ����� �� a*b
 * Ҳ���Ƕ��ڲ�ͬ��ҵ�񣬲���Ҫ�����޸�SegmentTree�Ĵ���
* @author zhanyuhao
* @version ����ʱ�䣺2020��3��3�� ����9:57:45
* ��˵��
 */
public interface Merger<E> {
	E merge(E a,E b);
}
