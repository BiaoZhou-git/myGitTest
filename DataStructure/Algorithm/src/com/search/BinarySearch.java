package com.search;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author tiko
 * @createDate 2020/1/4-12:37
 */
//二分查找
//mid = low + 1/2(high - low)
public class BinarySearch {
	public static void main(String[] args) {
		int size = 100;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		int index = binarySearch(arr, 0, arr.length-1, 9);
		int index2 = binarySearch2(arr, 0);
		System.out.println(index);
		System.out.println(index2);

		List<Integer> indexList = new ArrayList<>();
		indexList = binSearch(arr, 0, arr.length-1, 2);
		for (Integer integer : indexList) {
			System.out.print(integer + "\t");
		}
		System.out.println(indexList);



	}

	//前提：有序数组
	//递归实现 -> 基本实现
	public static int binarySearch(int[] arr, int left, int right, int key) {
		//递归出口1,未找到
		if (left > right || key < arr[left] || key > arr[right]) {
			return  -1;
		}

		int mid = (left + right) / 2;
		System.out.println("index:" + mid);

		if (arr[mid] > key) {
			return binarySearch(arr, left, mid-1, key);
		}else if (arr[mid] < key){
			return binarySearch(arr, mid+1, right, key);
		}else {
			return mid;//递归出口2，找到了
		}
	}

	public static ArrayList<Integer> binSearch(int[] arr, int left, int right, int key) {
		//递归出口1,未找到
		if (left > right) {
			return  new ArrayList<>();
		}

		int mid = (left + right) / 2;

		if (arr[mid] > key) {
			return binSearch(arr, left, mid-1, key);
		}else if (arr[mid] < key){
			return binSearch(arr, mid+1, right, key);
		}else {
			//找到了，先把mid的值先存起来
			//1 3  3  3  4  5 6 9
			//    mid
			ArrayList<Integer> resultIndex = new ArrayList<>();
			//因为是有序的，所以找到的key应该在mid的左右两侧  对于这题而言，非常重要 以上的递归只会在一处，不会顺序执行

			//左侧查找
			int temp = mid -1;
			while (temp>=0 && arr[temp] == key) {
				resultIndex.add(temp);
				temp--;
			}

			//插入当前mid
			resultIndex.add(mid);

			//右侧查找
			temp = mid + 1;
			while (temp<=right && arr[temp] == key) {
				resultIndex.add(temp);
				temp++;
			}

			//返回结果集
			return resultIndex;
		}
	}

	//非递归实现
	public static int binarySearch2(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		int mid = 0;

		if(low > high) {//假设是一个空数组时，low>high
			return -1;
		}
		while (low<=high) {
			mid = (low +high)/2;
			if(arr[mid]<key){
				low = mid + 1;
			}else if(arr[mid]>key){
				high = mid -1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
