package com.service;

import java.util.ArrayList;
import java.util.Random;

public class MoveWindowMaxValue {
	
	public static void main(String[] args){
		int n=1000000;
		Integer a[] = new Integer[n];
		for(int i=0;i<n;i++){
			a[i]=new Random().nextInt(n);
		}
		int k = 200000;
		Long startTime = System.currentTimeMillis();
		ArrayList<Integer> c = getWindowMaxValueArray(a, k);
		Long endTime = System.currentTimeMillis();
		System.out.print((endTime - startTime) + ",");
		System.out.print(c.size() + ",");
	}

	private static ArrayList<Integer> getWindowMaxValueArray(Integer[] a, int k) {
		int start = 0, end = start + k - 1;
		ArrayList<Integer> b = new ArrayList<Integer>();
		while(end < a.length){
			b.add(getMaxValue(a, start, end));
			start++;
			end++;
		}
		return b;
	}

	private static int getMaxValue(Integer[] a, int start, int end) {
		int max = Integer.MIN_VALUE;
		for(int i=start;i<=end;i++){
			if(a[i] > max){
				max = a[i];
			}
		}
		return max;
	}
}
