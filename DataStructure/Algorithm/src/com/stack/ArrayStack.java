package com.stack;

import javax.sound.midi.Soundbank;
import java.lang.invoke.VarHandle;

/**
 * @author tiko
 * @createDate 2019/12/29-20:14
 */
//用数组模拟栈，top指向栈顶，且初始值设为-1
public class ArrayStack {
	private int maxSize;//栈的大小
	private int[] stack;//数组模拟栈，数据放在该栈内
	private int top = -1;//top表示栈顶，初始值为-1
	private int size = 0;//栈中元素个数

	//创建一个容量为maxSize大小容量的栈
	public ArrayStack(int num) {
		this.maxSize = num;
		stack = new int[this.maxSize];
	}

	//判栈空
	public boolean isEmpty() {
		return top == -1;
	}

	//判栈满
	public boolean isFull() {
		return top == maxSize -1;
	}

	public void push(int value) {
		//压栈，先判满
		if (isFull()){
			System.out.println("栈满，无法入栈！");
			return;
		}
		//执行到此，说明可以入栈
		top++;
		stack[top] = value;
		size++;//数据个数加1
	}

	public int pop() {
		//出栈，先判空
		if(isEmpty()) {
			new RuntimeException("栈空，无法出栈！");
		}

		int temp = stack[top];
		top--;
		size--;
		return temp;
	}

	//遍历时，需要从栈顶开始显示
	public void list() {
		//判空
		if(isEmpty()) {
			System.out.println("栈空！无法遍历...");
			return;
		}

		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\t", i, stack[i]);
		}
		System.out.println();
		return;
	}

	public int getSize() {
		return size;
	}
}
