package com.sort.selectsort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2020/1/2-13:15
 */
public class SelectDemo {

	public static void main(String[] args) {
		int size = 800000;
		int[] array = new int[size];
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = simpleDateFormat.format(date);
		System.out.println(strDate);


		for (int i = 0; i < size; i++) {
			array[i] = (int)(Math.random() * size *2);
		}
//		System.out.println(Arrays.toString(array));
		SelectSort.selectSort(array);
//		System.out.println(Arrays.toString(array));

		date = new Date();
		strDate = simpleDateFormat.format(date);
		System.out.println(strDate);
	}


}
