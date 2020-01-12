package com.sort.bubblesort;

import java.util.Arrays;

/**
 * @author tiko
 * @createDate 2020/1/2-10:19
 */
public class BubbleSortOptimization {
	public static void sort(int[] arr) {//原地修改
		//arr初始为[-1,-2,9,10,3]
		//有arr.length个元素，一般需要arr.length-1次大的循环
		int temp = 0;
		boolean isSwapFlag = false;//标识变量，表示是否进行过交换。true：进行过交换.false:未进行过交换
		for (int i = 0; i < arr.length - 1; i++) {//需要arr.length-1次的循环;同时数组中只有一个元素也是可以处理的，不需要单独再处理
			for (int j = 0; j < arr.length - 1 - i; j++) {//这其中j的循环判定条件，依照前面i的选取不同而改变。
				//i总是代表前一个比较的索引
				if (arr[j] > arr[j + 1]) {
					isSwapFlag = true;//有过交换，flag设置为true
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			//这个if是一定可以执行的
			if(isSwapFlag == false) {//如果循环完这一次，发现没有发生过交换，说明已经排好序了。退出循环
				System.out.println("排好序了！，提前退出！");
				break;
			}else {//执行到此，说明有过交换，要进行下次循环，再将flag置为false用于下次判断
				isSwapFlag = false;
			}
//			System.out.println("第" + (i+1) + "趟" + Arrays.toString(arr));
		}
		return;
	}
}
