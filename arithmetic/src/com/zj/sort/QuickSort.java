package com.zj.sort;
/**
 * 快速排序
 * @author Administrator
 * 使用划分的实现进行排序-
 * 1、首先需要选择一个枢纽值pivot（将所有比枢纽值大的值放到枢纽值右面，比枢纽值小的值放到枢纽值左边）
 * 2、默认先选定数组最右面的值为枢纽值，然后两个指针 （left & right）分别从数组的左面往右面移动，右面网左面移动
 * 		left : 从数组的0元素开始遍历；  right ： 从数组的右起第二个元素开始遍历
 * 		left遍历到比pivot大的值停下，right遍历到比pivot小的值停下，然后交换两个值的位置。然后继续遍历，直到 left >= right 停止
 * 		特别 >> left停止的位置以及右侧数组元素都比pivot大，左侧数组元素都比pivot小    ，这样讲left指定的位置和pivot交换位置，
 * 		这样就保证了 pivot 的左侧元素都比pivot小  右侧元素都比pivot大
 * 3、然后从2步之后的pivot的位置，将数组分为两个数组，分别递归1、2步骤，直到最后划分的数组大小为1，不可再划分，这排序结束
 */
public class QuickSort extends Sort{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickSort quick = new QuickSort();
		
		quick.sys();
		quick.quickSort(0, array.length-1);
		quick.sys();
		
	}
	
	/**
	 * 需要递归的排序方法
	 * @param left
	 * @param right
	 */
	private void quickSort(int left, int right){
		//right - left <= 0 说明数组不可再分，则结束
		if(right - left <= 0){
			return ;
		}else{
			//将数组最右侧元素作为枢纽值，进行快排
			int pivot = array[right];  //方法一，确定pivot
			//int pivot = medianOf3(left, right);  // 方法二，三项数据取中获取pivot
			//找到进一步划分数组的枢纽值的位置
			int partition = partitionArray(left,right,pivot);
			//递归的调用排序，分别对根据产生的枢纽值的位置分割产生的左右两个新的数据进行排序
			quickSort(left,partition-1);
			quickSort(partition+1,right);
		}
	}

	/**
	 * 将数组以枢纽值pivot为准，进行快排，
	 * 将大于pivot的元素移动到pivot的右侧，将小于pivot的元素移动到pivot的左侧
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	private int partitionArray(int left,int right,int pivot){
		//左侧指针从0元素开始，右侧指针从右起第二个元素开始（右起第一个元素时枢纽值pivot）
		 int leftPtr = left - 1;
		 int rightPtr = right;
		 
		 while(true){
			 //向右移动left指针，直到找到比pivot大的元素停止
			 while(array[++leftPtr] < pivot)
				 ;
			 //向左移动right指针，直到找到比pivot小的元素停止
			 while(array[--rightPtr] > pivot)
				 ;
			 //如果left下标大于right下标，这证明数组已经遍历完，结束
			 if(leftPtr >= rightPtr)
				 break;
			 else
				 swap(leftPtr,rightPtr);//交换left指定的大于pivot的值和right指定的小于pivot的值
		 }
		 //遍历结束，将数组最右侧选定的pivot 和 left最后指定的大于pivot元素交换位置，保证了 pivot 右侧数组元素都大于pivot  左侧数组元素都小于pivot
		 swap(leftPtr,right);
		 //返回pivot所在的位置下标
		 return leftPtr;
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
		swap(middle,right);
		return array[right];
	}
	
}
