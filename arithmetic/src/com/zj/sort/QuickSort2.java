package com.zj.sort;
/**
 * 快速排序算法，采用三项数据取中确定pivot值
 * 算法思想：
 * 对只有三个或者更少数据项的子数组进行排序，当数组只有一个数据项时直接返回；
 * 有两个数据项时，如果需要，则交换这两个数据项位置，有三个数据项时，对三个数据项进行排序
 * 适用于数组元素至少含有四个数据项时
 * 
 * @author Administrator
 *
 */
public class QuickSort2 extends Sort{

	public static void main(String[] arg0){
		
		QuickSort2 sort = new QuickSort2();
		sort.quickSort(0, array.length - 1);
		sort.sys();
	}
	
	private void quickSort(int left,int right){
		int size = right - left + 1;
		/**
		 * 也可以定义数据项小于9（根据具体情况确定）时，使用插入排序（根据具体情况确定），以获得更高的效率
		 */
		if(size <= 3){
			//直接进行排序 
			manualSort(left,right);
		}else{
			//采用传统快速排序
			int pivot = medianOf3(left,right);
			int partition = partitionIt(left,right,pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}
	
	private int partitionIt(int left,int right,int pivot){
		
		int leftPtr = left;
		int rightPtr = right - 1;
		
		while(true){
			while(array[++leftPtr] <= pivot);
			while(array[--rightPtr] >= pivot);
			
			if(leftPtr >= rightPtr){
				break;
			}else{
				swap(leftPtr,rightPtr);
			}
		}
		swap(leftPtr, right - 1);
		return leftPtr;
	}
	
	private void manualSort(int left,int right){
		int size = array.length;
		if(size <= 1){
			return ;
		}else if(size == 2){
			if(array[left] > array[right]){
				swap(left,right);
			}
		}else{
			int middle = (left + right) / 2;
			if(array[left] > array[middle]){
				swap(left,middle);
			}else if(array[left] > array[right]){
				swap(left,right);
			}else if(array[middle] > array[right]){
				swap(middle,right);
			}
		}
	}
	
	/**
	 * 三项数据取中，获得枢纽值pivot
	 * @param left
	 * @param right
	 * @return
	 */
	private int medianOf3(int left,int right){
		
		int middle = (left + right) / 2;
		
		if(array[left] > array[middle]){
			swap(left,middle);
		}
		if(array[left] > array[right]){
			swap(left,right);
		}
		if(array[middle] > array[right]){
			swap(middle,right);
		}
		swap(middle,right-1);
		return array[right-1];
	}
}
