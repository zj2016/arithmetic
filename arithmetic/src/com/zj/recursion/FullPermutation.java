package com.zj.recursion;

public class FullPermutation {

	private static String[] array = {"1","2","2","3","4","5"};
	private static int num = 0;
	
	public static void main(String[] arg0){
		FullPermutation full = new FullPermutation();
		
		int size = array.length;
		full.full(0, size-1, size);
		System.out.println(num);
	}
	
	private void full(int start,int end,int size){
		if(start == end){
			sys();
			num++;
		}else{
			for(int i = start; i <= end; i++){
				swap(start, i);
				full(start+1,end,size);
				swap(start, i);
			}
		}
	}
	
	private void swap(int a,int b){
		String s = array[a];
		array[a] = array[b];
		array[b] = s;
	}
	
	private void sys(){
		StringBuffer sb = new StringBuffer();
		for(String s : array){
			sb.append(s).append(",");
		}
		System.out.println(sb.toString());
	}
	
}
