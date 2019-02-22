package com.lcp.java.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntPredicate;

public class LearnArray {
	/**
	 * ����������
	 * �����ڶ�����
	 * @param size
	 * @param value
	 * @return
	 */
	int[] generate(int size, int value) {
		int[] r = new int[size];
		for (int i = 0; i < r.length; i++) {
			r[i] = (int) (Math.random() * (value * 2 + 1)) - value;
		}
		return r;
	}

	/**
	 * ���������
	 * int[] a��int a[]������д����һ���ģ�����ǰһ�ָ��Ƴ�
	 */
	private void declare() {
		System.out.println("LearnArray.declare():");
		//����C++
		int[] a;
		a=new int[2];
	}
	
	/**
	 * ����ĳ�ʼ��
	 */
	private void init() {
		System.out.println("LearnArray.init():");
		int [] a=new int[2];
		int [] b=new int[] {2,2,4};
		//int[] c=new int[2]{2,3}; ����д���Ǵ����
	}
	
	/**
	 * ���鿽��
	 */
	private void copyArray() {
		System.out.println("LearnArray.copyArray():");
		int[] a=generate(10, 5);
		int[] b=new int[4];
		System.arraycopy(a, 0, b, 0, 4);
		
		for(int value:a)
			System.out.print(value+" ");
		System.out.println();
		for(int value:b)
			System.out.print(value+" ");
		System.out.println();
	}
	
	/**
	 * ��ά����
	 */
	private void twoDimensionArray() {
		System.out.println("LearnArray.twoDimensionArray():");
		
		//�������ʼ��
		int[][] m=new int[2][3];
		int[][] n=new int[][] {{2,4,2,3},{1}};
		//��ά����
		int[][][] threeDimension=new int[2][2][2];
		
		for(int[] array:n)
			for(int value:array)
				System.out.print(value+" ");
		System.out.println();
		
		//ע��㣬�ٳ�ʼ��һάӦ�����
		
		//int[][] l=new int[2][]����
		//int[][] l=new int[][2]������
		int [][] l=new int[2][];
		//ֱ�ӷ���l[0]��null������l[0][0]�ᱨ��ָ��
	}
	
	/**
	 * Arrays�ľ�̬���߷���
	 */
	private void arrayUtil() {
		System.out.println("LearnArray.ArrayUtil():");
		
		//������Χ����
		System.out.println("copyOfRange():");
		int[] a=generate(10, 5);
		int[] b=Arrays.copyOfRange(a, 0, 10);
		
		System.out.println(Arrays.toString(b));
		
		//�������
		System.out.println("toString():");
		System.out.println(Arrays.toString(a));
		
		//��������
		System.out.println("sort():");
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//������ֲ���
		System.out.println("binaySearch():");
		System.out.println("0��λ�ã� "+Arrays.binarySearch(a, 0));
		
		//�ж������Ƿ���ͬ
		System.out.println("equal():");
		System.out.println(Arrays.equals(a, b));
		
		//�������
		System.out.println("fill():");
		Arrays.fill(b, 0);
		System.out.println(Arrays.toString(b));
	}
	
	public static void main(String[] args) {
		LearnArray learnArray=new LearnArray();
		learnArray.declare();
		learnArray.init();
		learnArray.copyArray();
		learnArray.twoDimensionArray();
		learnArray.arrayUtil();
	}
}
