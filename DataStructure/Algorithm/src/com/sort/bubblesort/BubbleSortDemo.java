package com.sort.bubblesort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2020/1/2-9:43
 */
public class BubbleSortDemo {
	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strFormat = simpleDateFormat.format(date);
		System.out.println(strFormat);

		int size = 800000;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int)(Math.random() * size * 2);
		}

		BubbleSort.sort(array);

		date = new Date();
		strFormat = simpleDateFormat.format(date);
		System.out.println(strFormat);

		System.out.println();


		int[] array2 = new int[size];
		for (int i = 0; i < size; i++) {
			array2[i] = (int)(Math.random() * size * 2);
		}

		date = new Date();
		strFormat = simpleDateFormat.format(date);
		System.out.println(strFormat);

		BubbleSortOptimization.sort(array2);

		date = new Date();
		strFormat = simpleDateFormat.format(date);
		System.out.println(strFormat);
	}

}
