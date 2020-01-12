package com.queue;

/**
 * @author tiko
 * @createDate 2019/12/23-13:48
 */
public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int size) {
		maxSize = size;
		front = -1;//指向队中第一个元素的前一个位置[不含]
		rear = -1;//指向对中最后一个位置[含]
		//front，rear只是标记，其本身并不占有数组空间
		arr = new int[maxSize];
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return rear == maxSize -1;
	}

	public void push(int n) {
		if(isFull()){
			throw  new RuntimeException("队满，数据无法再队");
		}
		else {
			arr[++rear] = n;
		}
	}

	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("队空，无法取出数据");
		}
		else {
			return arr[++front];
		}
	}

	public int getFront() {
		if(isEmpty()) {
			throw new RuntimeException("队空，无法取出数据");
		}
		else {
			return arr[front + 1];
		}
	}

	public void show() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}
