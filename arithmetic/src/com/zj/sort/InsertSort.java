package com.zj.sort;
/**
 * 插入排序
 * @author Administrator
 *
 */
public class InsertSort extends Sort{

	
	public static void main(String[] arg0){ 
		
		InsertSort is = new InsertSort();
		is.insertSort(array);
		
	}
	
	/**
	 * 算法思想
	 * 1、选定一个标记位（数组的下标1开始）
	 * 2、保证标记位左侧局部数据是有序的
	 * 3、然后在左侧局部有序数据中找到合适位置，将标记位元素插入此位置（涉及左侧数据的右移操作）
	 * 4、然后选定下一个标记位，重复上述操作
	 * @param a
	 */
	public void insertSort(int[] a){
		
		//从数组第2个元素开始，数组元素依次作为标记位
		for(int tag = 1; tag < a.length; tag++){
			
			int temp = a[tag];
			int in = tag;
			
			//循环左侧有序数列，将比标记位的大的元素依次右移
			while(in > 0 && a[in - 1] >= temp){
				a[in] = a[in - 1];
				in--;
			}
			//然后将标记位元素插入
			a[in] = temp;
		}
		
		sys();
	}
}
