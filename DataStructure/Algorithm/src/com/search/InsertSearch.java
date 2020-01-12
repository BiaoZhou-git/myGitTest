package com.search;

import java.util.function.Predicate;

/**
 * @author tiko
 * @createDate 2020/1/4-14:03
 */
//插值查找
//                 key - arr[low]
//mid = low + ——————————————————(high - low)
//	          arr[high]-arr[low]
//在判断退出是，得加上边界判断，应为前面的因子可能出现越界
public class InsertSearch {
	public static void main(String[] args) {
		int size = 100;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		int index = insertSearch(array, 0, array.length-1, 10);
		System.out.println(index);

	}
	public static int insertSearch(int[] arr, int left, int right, int key) {
		//递归出口1,未找到
		//这里的key < arr[left] || key > arr[right]是必须需要的，因为不知道key是多少，那么插值就很有可能导致数组越界
		//原因是：key参与了计算mid值
		if (left > right || key < arr[left] || key > arr[right]) {
			return  -1;
		}

		int mid = left + ((key - arr[left])/(arr[right] - arr[left])) * (right - left);
		System.out.println("index:" + mid);

		if (arr[mid] > key) {
			return insertSearch(arr, left, mid-1, key);
		}else if (arr[mid] < key){
			return insertSearch(arr, mid+1, right, key);
		}else {
			return mid;//递归出口2，找到了
		}
	}
}

