package com.lcp.java.core;

import java.util.Collections;

/**
 *  执行顺序
 * 父类静态代码块
 * 子类静态代码块
 * 父类非静态代码块
 * 父类构造函数
 * 子类非静态代码块
 * 子类构造函数
 * @author buaaL
 *
 */
public class ExecutionOrder extends ExecutionParent{

	private static String STR="child class static variable";

	/**
	 * 子类静态代码块
	 */
	static {
		System.out.println("child class static block： "+STR);
	}
	
	/**
	 * 子类构造函数
	 */
	public ExecutionOrder()
	{
		super();
		System.out.println("child class constructor method");
	}
	
	/**
	 * 子类非静态代码块
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
	 * 父类静态代码块
	 */
	static {
		System.out.println("superclass static block: "+STR);
	}
	
	/**
	 * 父类构造函数
	 */
	public ExecutionParent()
	{
		System.out.println("super class constructor method");
	}
	
	/**
	 * 父类非静态代码块
	 */
	{
		System.out.println("super class block");
	}
}
