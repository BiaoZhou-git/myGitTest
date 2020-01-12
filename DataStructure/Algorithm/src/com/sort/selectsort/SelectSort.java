package com.sort.selectsort;

/**
 * @author tiko
 * @createDate 2020/1/2-12:32
 */
public class SelectSort {
	public static void  selectSort(int[] arr) {
		int minIndex = 0;
		for (int i = 0; i < arr.length-1; i++) {//循环arr.length-1次
			minIndex = i;//记录最小值所在的索引
			for (int j = i+1; j < arr.length ; j++) {
				if(arr[minIndex] > arr[j]){//如果当前值arr[i]的值比最小值还小，则更新最小值所在的索引
					minIndex = j;
				}
			}
			//内层for结束，说明找打了最小值所在的索引
			if(minIndex != i) {//如果最小值不是初始预设的索引，说明最小值所在索引在后面，这时需要调换位置
				//这里是一种优化
				int temp = 0;
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}//这里的else可以不写，因为如果mixIndex == i此时，不需要调换位置，因为i此时就是最小值所在的下标
		}
		return;
	}
}
