package com.lcp.java.core;

public class LearnJavaBasic {

	public static void main(String[] args) {
		ShallowCloneExample e1=new ShallowCloneExample();
		ShallowCloneExample e2=null;

		try {
			e2=e1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		e1.set(1, 222);
		e1.setNum(333);
		System.out.println(e2.get(1));
		System.out.println(e2.getNum());
	}
}

class ShallowCloneExample implements Cloneable {

	private int[] arr;
	public int num;
	public ShallowCloneExample() {
		arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	public void set(int index, int value) {
		arr[index] = value;
	}

	public int get(int index) {
		return arr[index];
	}
	
	public void setNum(int i) {
		num=i;
	}
	
	public int getNum() {
		return num;
	}
	@Override
	protected ShallowCloneExample clone() throws CloneNotSupportedException {
		return (ShallowCloneExample) super.clone();
	}
}
