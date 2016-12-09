package com.zj.sort;

public class Sort {
	
	protected static int[] array = {69,0,70,6,38,23,38,24,56,44,26,73,77,30,45,97,65};
	
	/**
	 * 交换数组两个元素位置
	 * @param left
	 * @param right
	 */
	protected void swap(int left, int right){
		int x = array[left];
		array[left] = array[right];
		array[right] = x;
	}
	
	
	protected void sys(){
		StringBuilder sb = new StringBuilder();
		for(int a : array){
			sb.append("" + a).append(",");
		}
		System.out.println(sb.toString());
	}
}
