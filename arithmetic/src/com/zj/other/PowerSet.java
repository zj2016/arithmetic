package com.zj.other;

/**
 * 问题描述：
 * 给定一个数组，将数组元素全排列（无顺序）
 * 
 * 例子：
 * input：{1,2,3}
 * output: {},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}
 * 
 * @author Administrator
 * 
 * 思想，利用二进制
 * {1,2,3}  -->  {001,010,100}
 *	
 * 利用7种进行筛选 {001,010,011,100,101,110,111}  刚好进行与运算
 */
public class PowerSet {

	private static void getPowerSet(int[] array){
		
		//数组长度
		int len = array.length;
		//n的元素的排列方法有2的n次方减1种（2^n - 1）    
		int total = 1 << len;//多少种组合
		
		//有多少种组合，即循环多少次进行输出
		for (int i = 0; i < total; i++) {
			
			for (int j = 0; j < len; j++) {
				
				//进行二进制与运算，得出符合的组合
				if((i & (1 << j)) != 0){
					System.out.print(array[j]);
				}
				
			}
			System.out.println();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3};
		getPowerSet(array);
		
	}
	
}
