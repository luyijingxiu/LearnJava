package com.lcp.learnutil;

public enum SystemOutUtil {
	INSTANCE;
	static int LENGTH=25;
	public void printSplitLine(int size) {

		for (int i = 0; i < size; i++) {
			System.out.print('-');
		}
		System.out.println();
	}

	public void printSplitLine() {
		printSplitLine(LENGTH);
	}
	
	public void printMark(String str) {
		int preL=(LENGTH-str.length())/2;
		for(int i=0;i < preL; i++) {
			System.out.print('-');
		}
		System.out.print(str);
		for(int i=0;i <LENGTH-str.length()-preL; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
}
