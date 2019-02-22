package com.lcp.learnutil;

public enum SystemOutUtil {
	INSTANCE;
	public void printSplitLine(int size) {

		for (int i = 0; i < size; i++) {
			System.out.print('-');
		}
		System.out.println();
	}

	public void printSplitLine() {
		printSplitLine(25);
	}
}
