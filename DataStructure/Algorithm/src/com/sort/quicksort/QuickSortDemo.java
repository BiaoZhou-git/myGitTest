package com.sort.quicksort;

import com.sort.insertsorrt.InsertSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author tiko
 * @createDate 2020/1/3-12:19
 */
public class QuickSortDemo {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = simpleDateFormat.format(date);
		System.out.println(strDate);

		int size = 2;
		int[] array = {2, 1};
//		for (int i = 0; i < size; i++) {
//			array[i] = (int)(Math.random() * size *2);
//		}

		QuickSort.quickSort(array, 0, array.length-1);
		date = new Date();
		strDate = simpleDateFormat.format(date);
		System.out.println(strDate);
		System.out.println(Arrays.toString(array));

	}
}
