package com.queue;

/**
 * @author tiko
 * @createDate 2019/12/24-9:35
 */
public class CircleArrayQueue {
	private int[] arr;
	private int front = 0;//指向队列中第一元素的位置
	private int rear = 0;//执行队列中最后一个元素的后一个空的位置
	private int maxSize;

	public CircleArrayQueue(int maxsize) {//浪费一个空间，来实现循环队列
		maxSize = maxsize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}

	public void push(int n) {
		if(isFull()) {
			//队满时，无法入队；抛出异常
			throw new RuntimeException("队满，无法入队");
		}
		arr[rear] = n;
		//rear后移，考虑取模
		rear = (rear + 1) % maxSize;
	}

	public int pop() {
		if(isEmpty()){
			//队空无法出队，抛出运行时异常
			throw new RuntimeException("队空，无法出队");
		}
		int temp = arr[front];
		//front后移，考虑取模
		front = (front + 1) % maxSize;
		return temp;
	}

	public int headOfQueue() {
		if(isEmpty()) {
			System.out.println("队空无法出队");
		}
		return arr[front];
	}

	public void shoｗ() {
		if(isEmpty()) {
			System.out.println("队列为空，没有数据···");
			return;
		}

		for (int i = front; i < front + sizeOfQueue(); i++) {
			System.out.printf("arr[%d]:%d \t", i % maxSize, arr[i % maxSize]);
		}
		System.out.println();
	}

	public int sizeOfQueue() {
		return (rear + maxSize - front) % maxSize;
	}
}
