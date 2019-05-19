/*
 * 学习java string
 */
package com.lcp.java.core;

import com.lcp.learnutil.SystemOutUtil;

public class LearnString {
	public static void main(String[] args) {
		LearnString learnString = new LearnString();
		learnString.strcat();
	}

	private void strcat() {
		SystemOutUtil.INSTANCE.printMark("测试string拼接时候的内存分配");
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";// 常量池中的对象
		String str4 = str1 + str2; // 在堆上创建的新的对象
		String str5 = "string";// 常量池中的对象
		String str6 = str1 + "ing";
		System.out.println(str3 == str4);// false
		System.out.println(str3 == str5);// true
		System.out.println(str4 == str5);// false
		System.out.println(str3 == str6);// false
		System.out.println(str4 == str6);// false
	}
}
