package com.sort.insertsorrt;

/**
 * @author tiko
 * @createDate 2020/1/2-18:06
 */
public class InsertSort {
	public static void insertSort(int[] arr) {//有序部分和无序部分；假定前面为有序部分

		int insertValue = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertValue = arr[i];
			insertIndex = i -1;
			//从后往前比较,边找边移动，直到插入位置
			while (insertIndex >=0 && insertValue < arr[insertIndex]) {//insertIndex >=0 确保index不越界
				//当insertValue<arr[insertIndex]时，说明找到要插入的位置
				//此时，将该arr[insertIndex]后移；比较一个移动一个
				arr[insertIndex+1] = arr[insertIndex];//[1,4,2,5]->[1,4,4,,5]
				insertIndex --;
			}
			//退出时insertValue >= arr[insertIndex]
			//因为是升序，insertValue应该在insertIndex后面一个指向的位置
			arr[insertIndex + 1] = insertValue;
		}


//		for (int i = 1; i < arr.length; i++) {
//			int insertValue = arr[i];//要插入的值
//			int index = i-1;//初始的索引
//			for (; index >=0 ; index--) {//从后向前扫描
//				if(insertValue > arr[index]) {//如果要插入的值，大于此时j指向。说明找到要拆入的位置了
//					break;
//				}
//			}
//			int insertIndex = index;//记录要插入的索引为insertIndex，真正要插入的位置为insertIndex+1
//
//			for (int k = i-1; k >= insertIndex + 1; k--) {//从初始的index到insertIndex的位置，数据以此向后移
//				arr[k+1] = arr[k];
//			}
//			arr[insertIndex + 1] = insertValue;//将要插入的值插入insertIndex+1指向的位置
//		}
	}
}
