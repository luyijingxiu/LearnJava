package com.lcp.java.core;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *   ���캯�����������������¡����������ͨ���޸��ⲿ���øı�
 * ��������Ķ��������
 * @author buaaL
 *
 */
public class ConstructorRefence {
	private List<Integer> list;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public ConstructorRefence(List<Integer> list) {
		this.list = list;
	}

	public ConstructorRefence() {
	}
	
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		ConstructorRefence test=new ConstructorRefence(list);
		
		System.out.println("list[0]="+list.get(0));
		System.out.println("test.list[0]="+test.list.get(0));
	}
}
