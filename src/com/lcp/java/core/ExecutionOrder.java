package com.lcp.java.core;

import java.util.Collections;

/**
 *  ִ��˳��
 * ���ྲ̬�����
 * ���ྲ̬�����
 * ����Ǿ�̬�����
 * ���๹�캯��
 * ����Ǿ�̬�����
 * ���๹�캯��
 * @author buaaL
 *
 */
public class ExecutionOrder extends ExecutionParent{

	private static String STR="child class static variable";

	/**
	 * ���ྲ̬�����
	 */
	static {
		System.out.println("child class static block�� "+STR);
	}
	
	/**
	 * ���๹�캯��
	 */
	public ExecutionOrder()
	{
		super();
		System.out.println("child class constructor method");
	}
	
	/**
	 * ����Ǿ�̬�����
	 */
	{
		System.out.println("child class block");
	}
	
	public static void main(String[] args) {
		ExecutionOrder order=new ExecutionOrder();
	}
}

class ExecutionParent{
	private static String STR="super class static variable";
	/**
	 * ���ྲ̬�����
	 */
	static {
		System.out.println("superclass static block: "+STR);
	}
	
	/**
	 * ���๹�캯��
	 */
	public ExecutionParent()
	{
		System.out.println("super class constructor method");
	}
	
	/**
	 * ����Ǿ�̬�����
	 */
	{
		System.out.println("super class block");
	}
}
