package com.lcp.java.core;

import java.util.HashMap;
import java.util.Map;

public class LearnHashMap {
	Map<Integer,Integer> map=new HashMap<>();
	public static void main(String[] args) {
		int hash=8;
		int length1=2<<4;
		System.out.println((hash&(length1-1))+"   "+(hash&(2*length1-1)));
		Map<Integer,Integer> map=new HashMap<>();
		map.put(1, 1);
		map.put(2,2);
		map.remove(1);
		System.out.println(map.get(1));
	}
}
