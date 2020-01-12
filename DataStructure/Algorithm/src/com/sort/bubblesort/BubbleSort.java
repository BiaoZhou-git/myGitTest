package com.sort.bubblesort;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * @author tiko
 * @createDate 2020/1/2-9:27
 */
public class BubbleSort {
	public static void sort(int[] arr) {//原地修改
		//arr初始为[-1,-2,9,10,3]
		//有arr.length个元素，一般需要arr.length-1次大的循环
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {//需要arr.length-1次的循环;同时数组中只有一个元素也是可以处理的，不需要单独再处理
			for (int j = 0; j < arr.length -1 - i; j++) {//这其中j的循环判定条件，依照前面i的选取不同而改变。
				//i总是代表前一个比较的索引
				if(arr[j]>arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] =temp;
				}
			}
//			System.out.println("第" + (i+1) + "趟:" + Arrays.toString(arr));
		}
		return;

//		//第一次
//		int temp =0;
//		for (int i = 0; i < arr.length-1-0; i++) {
//			//假定有两个指针i和i+1。i+1会循环到arr.length-1，自然i会循环到arr.length-1-1. i:0->arr.length-2（含）[<arr.length-1]
//			if(arr[i]>arr[i+1]){
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] =temp;
//			}
//		}
//
//		//第二次
//		for (int i = 0; i < arr.length-1-1; i++) {
//			//假定有两个指针i和i+1。i+1会循环到arr.length-1，自然i会循环到arr.length-1-1. i:0->arr.length-2（含）[<arr.length-1]
//			if(arr[i]>arr[i+1]){
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] =temp;
//			}
//		}
//		//第3次
//		for (int i = 0; i < arr.length-1-2; i++) {
//			//假定有两个指针i和i+1。i+1会循环到arr.length-1，自然i会循环到arr.length-1-1. i:0->arr.length-2（含）[<arr.length-1]
//			if(arr[i]>arr[i+1]){
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] =temp;
//			}
//		}
//
//		//第arr.length-1次
//		for (int i = 0; i < arr.length-1-(arr.length-1-1); i++) {
//			//假定有两个指针i和i+1。i+1会循环到arr.length-1，自然i会循环到arr.length-1-1. i:0->arr.length-2（含）[<arr.length-1]
//			if(arr[i]>arr[i+1]){
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] =temp;
//			}
//		}
//		return arr;
	}
}
