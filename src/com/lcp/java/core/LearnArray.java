package com.lcp.java.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntPredicate;

public class LearnArray {
	/**
	 * 数组生成器
	 * 可用于对数器
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
	 * 数组的声明
	 * int[] a和int a[]这两种写法是一样的，但是前一种更推崇
	 */
	private void declare() {
		System.out.println("LearnArray.declare():");
		//类似C++
		int[] a;
		a=new int[2];
	}
	
	/**
	 * 数组的初始化
	 */
	private void init() {
		System.out.println("LearnArray.init():");
		int [] a=new int[2];
		int [] b=new int[] {2,2,4};
		//int[] c=new int[2]{2,3}; 这种写法是错误的
	}
	
	/**
	 * 数组拷贝
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
	 * 二维数组
	 */
	private void twoDimensionArray() {
		System.out.println("LearnArray.twoDimensionArray():");
		
		//声明与初始化
		int[][] m=new int[2][3];
		int[][] n=new int[][] {{2,4,2,3},{1}};
		//三维数组
		int[][][] threeDimension=new int[2][2][2];
		
		for(int[] array:n)
			for(int value:array)
				System.out.print(value+" ");
		System.out.println();
		
		//注意点，少初始化一维应该如何
		
		//int[][] l=new int[2][]可以
		//int[][] l=new int[][2]不可以
		int [][] l=new int[2][];
		//直接访问l[0]是null，访问l[0][0]会报空指针
	}
	
	/**
	 * Arrays的静态工具方法
	 */
	private void arrayUtil() {
		System.out.println("LearnArray.ArrayUtil():");
		
		//拷贝范围数组
		System.out.println("copyOfRange():");
		int[] a=generate(10, 5);
		int[] b=Arrays.copyOfRange(a, 0, 10);
		
		System.out.println(Arrays.toString(b));
		
		//数组输出
		System.out.println("toString():");
		System.out.println(Arrays.toString(a));
		
		//数组排序
		System.out.println("sort():");
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//数组二分查找
		System.out.println("binaySearch():");
		System.out.println("0的位置： "+Arrays.binarySearch(a, 0));
		
		//判断数组是否相同
		System.out.println("equal():");
		System.out.println(Arrays.equals(a, b));
		
		//填充数组
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
