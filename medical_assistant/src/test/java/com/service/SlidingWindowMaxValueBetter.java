package com.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class SlidingWindowMaxValueBetter {

	public static ArrayList<Integer> sort(Integer a[], int k){
		if(a.length==0||a.length<k){
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> maxWindow = new ArrayList<Integer>();
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			while(!deque.isEmpty()&&(a[i]>a[deque.peekLast()])){
				deque.pollLast();
			}
			deque.offerLast(i);
		}
		for(int i=k;i<a.length;i++){
			maxWindow.add(a[deque.peekFirst()]);
			while(!deque.isEmpty()&&(a[i]>a[deque.peekLast()])){
				deque.pollLast();
			}
			deque.offerLast(i);
			if(!deque.isEmpty()&&(deque.peekFirst()<i-k+1)){
				deque.pollFirst();
			}
		}
		maxWindow.add(a[deque.peekFirst()]);
		 return maxWindow;
		
	}
	
	public static void main(String[] args){
		int n=1000000;
		Integer a[] = new Integer[n];
		for(int i=0;i<n;i++){
			a[i]=new Random().nextInt(n);
		}
		int k = 200000;
		Long startTime = System.currentTimeMillis();
		ArrayList<Integer> b = sort(a, k);
		Long endTime = System.currentTimeMillis();
		System.out.print((endTime - startTime) + ",");
		System.out.print(b.size() + ",");
//		for(int i=0;i<b.length;i++){
//			System.out.print(b[i] + ",");
//		}
	}
	
}
