package com.lcp.java.core;

import java.util.UUID;

public class Test {
	public static Test t1 = new Test();
	
	
	static
	{
		System.out.println("block B");
	}
	
	{
		System.out.println("block A");
	}
	public static void main(String[] args) {
		Test t2=new Test();
		System.out.println(UUID.randomUUID());
	}
}
