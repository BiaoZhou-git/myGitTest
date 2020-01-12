package com.sort.quicksort;

import java.util.Arrays;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2020/1/3-9:50
 */
//快速排序，冒泡+递归 基于基准值分为左右两个部分
//要能够记下来,背也要背下来
public class QuickSort {
	public static void quickSort(int[] arr,int left,int right){
		if(left > right){//递归出口
			//即使是最后一个只含有一个元素的数组，也会执行该函数
			//quickSort(arr, left, r-1);为例，若数组只有一个元素，则left=0， r-1= lenth-1-1=-1
			//此时left > right,应该退出
			//若写left == right为退出条件，是永远不会执行的，同时也会跳过while (l<r) 不成立
			//将会无限递归
			return;
		}
		//若采用递归时，要保存传进来的参数
		int l = left;
		int r = right;

		int baseKey = arr[l];//设定基准值，这里用数组的第一个元素

		int temp = 0;//用来交换的变量

		while (l<r) {//因为不知道要交换几次，所以用while
			//先看右边，依次往左递减
			while (baseKey<=arr[r] && l<r) {
				//为什么加 l<r? 限制l与r的相遇
				//如果不加限制
				//      l
				//6 1 2 7 9 8 ->交换 6 1 7 2 9 8 这就产生了错误
				//    r
				r--;
			}
			//再看左边，依次往右递增
			while (arr[l]<=baseKey && l<r) {
				//为什么加 l<r? 限制l与r的相遇
				//如果不加限制
				//      l
				//6 1 2 7 9 8 ->交换 6 1 7 2 9 8 这就产生了错误
				//
				l++;
			}
			//如果满足条件则交换
			if (l < r) {
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}

		}

		//退出时，l，r是相等的
		//最后将基准为与i和j相等位置的数字交换
		arr[left] = arr[l];
		arr[l] = baseKey;

//		System.out.println(Arrays.toString(arr));
		//递归调用左半数组
		quickSort(arr, left, r-1);
		//递归调用右半数组
		quickSort(arr, l+1, right);
	}
}
