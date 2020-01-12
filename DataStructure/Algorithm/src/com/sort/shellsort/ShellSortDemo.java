package com.sort.shellsort;

import com.sort.insertsorrt.InsertSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author tiko
 * @createDate 2020/1/2-20:57
 */
public class ShellSortDemo {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = simpleDateFormat.format(date);
		System.out.println(strDate);

		int size = 800000;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int)(Math.random() * size *2);
		}
		ShellSort.shellSort2(array);
		date = new Date();
		strDate = simpleDateFormat.format(date);
		System.out.println(strDate);
		for (int i = 0; i < 10; i++) {
			System.out.println(array[i]);
		}
	}
}
