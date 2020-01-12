package com.search;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2020/1/4-12:24
 */
//顺序查找
public class SeqSearch {
	public static void main(String[] args) {
		int[] arr = {1, 3, 8, 9, 10, 3};
		int index = seqSearch(arr, 3);
		System.out.println(index);

		List<Integer> ints = new LinkedList<>();
		ints = seqSearch2(arr, 3);
		for (Integer anInt : ints) {
			System.out.println(anInt);
		}


	}

	//返回首次匹配的关键字下标
	public static int seqSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

    //返回匹配关键字的下标组成的int集合
	public static List<Integer> seqSearch2(int[] arr, int key) {
		List<Integer> ints = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				ints.add(i);
			}
		}
		return ints;

	}
}
