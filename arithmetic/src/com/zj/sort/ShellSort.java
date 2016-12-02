package com.zj.sort;
/**
 * 希尔排序
 * @author Administrator
 * 插入排序改进，增加一个间隔数列（数列中间隔值由  【h = h * 3 + 1】 产生）
 * -- 间隔数列 有多中规则产生，唯一的准则就是最后的最小间隔必须为1
 */
public class ShellSort {

	public static void main(String[] arg0){
		
		int a[] = {25,4,9,1,6,7,13,2,4};
		
		ShellSort shellSort = new ShellSort();
		shellSort.shellSort(a);
		
	}
	
	/**
	 * 算法思想：
	 * 通过引入间隔，使得插入排序的移位操作大大减少，增加排序效率。
	 *   
	 * 1、通过（h=h*3+1）产生一个间隔序列（序列最大值应该小于排序数组的长度，序列最小值固定为 1）
	 * 2、然后依次从间隔序列中由大到小的顺序，通过间隔对数组进行插入排序，知道最后间隔为1
	 * 3、间隔为1时，就是标准的插入排序。
	 * @param a
	 */
	public void shellSort(int[] a){
		
		int inner = 0;
		int temp = 0;
		
		int h = 1;
		while(h < a.length / 3){
			h = h * 3 + 1;
		}
		
		while(h > 0){
			
			for(int outer = h; outer < a.length ; outer++){
				temp = a[outer];
				inner = outer;
				
				while(inner >= h && a[inner - h] > temp){
					a[inner] = a[inner - h];
					inner -= h;
				}
				a[inner] = temp;
			}
			h = (h -1)/3;
		}
		
		for(int i : a){
			System.out.print(i + ",");
		}
		
	}
	
}
