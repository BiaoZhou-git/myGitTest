package com.sort.shellsort;

/**
 * @author tiko
 * @createDate 2020/1/2-20:27
 */

public class ShellSort {


	//shellsort 【移位法，基于插入排序】  优于下面的交换法
	public static void shellSort2(int[] arr) {
		//增量gap，逐步缩小增量
		for (int gap = arr.length; gap >0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {//               [5, 7, 4, 2, 3, 8. ]
				// 此中for循环的代码，就是之前的插入排序的算法： 注意，shell排序的精髓 gap
				//
				//记录待插入的值 insertValue
				int insertValue = arr[i];//待插入的值为组内当前值 比如2    *     ^
				//记录插入位置的下标 insertValue
				int insertIndex =  i-gap;//待插入的位置初始为当前插入值的下标的前一个组内下标 i-gap

				while (insertIndex>=0 && insertValue < arr[insertIndex]) {
					//满足条件，前一个组内值，向后移
					arr[insertIndex+gap] = arr[insertIndex];
					//同时指针向前移动 gap个
					insertIndex -= gap;
				}
				//循环退出，insertIndex指向位置的前一个组内位置
				// 1 3 * * *
				//   ^ ->insertIndex指向的位置，故4应该插入的位置在insertIndex+gap
				//   4
				arr[insertIndex+gap] = insertValue;
			}
		}
	}

	//shell排序，基于交换法
	public static void shellSort(int[] arr) {
		int temp = 0;
		for (int gap = arr.length; gap >0 ; gap /= 2) {//不断分组，增量越来越来越小，直到为1时，进行最后一趟排序，然后结束
			//gap即为组别，也为增量
			for (int i = gap; i < arr.length; i++) {//分组
				for (int j = i-gap; j >=0 ; j -= gap) {//从后往前循环，并且i增大后，循环的次数可能更多
					//这种从后往前的循环，是之前没遇到的
					//注意这里的,j-=gap，即体现了分组中每组中的步长变化
					if(arr[j+gap] < arr[j]) {//如果后面的小于前面的，交换数值；总是保证
						//交换法
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
		}
	}

}
