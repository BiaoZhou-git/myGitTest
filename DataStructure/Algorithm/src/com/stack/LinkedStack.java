package com.stack;

import javax.sound.midi.Soundbank;
import java.security.PublicKey;

/**
 * @author tiko
 * @createDate 2019/12/30-9:11
 */
//使用带头结点的单链表实现栈
public class LinkedStack {
	private int maxSize;
	private int size;
	private Node head = new Node();

	public LinkedStack(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;
		System.out.println("栈的最大容量为" + maxSize);
	}

	//判空
	public boolean isEmpty() {
		return size == 0;
	}
	//判满
	public boolean isFull() {
		return size == maxSize;
	}

	//入栈，使用头插法
	public void push(Node node) {
		if(isFull()) {
			System.out.println("栈满，无法进行入栈操作！");
			return;
		}
		//执行到此说明可以入栈
		Node p = head;
		node.next = p.next;
		p.next = node;
		size++;
		return;
	}

	public int pop() {
		//判空
		if(isEmpty()){
			new RuntimeException("栈空无法进行出栈操作！");
		}
		//执行到此说明可以出栈。栈中至少有一个元素
		//因为使用头插法，所以第一个元素即为栈顶元素
		Node p = head;
		int value = p.next.data;
		p.next = p.next.next;
		size--;
		return value;

	}
	public void list() {
		//判空
		if(isEmpty()) {
			System.out.println("栈空，无需遍历！");
			return;
		}
		//执行到此说明栈中至少有一个元素
		//因为之前使用头插法，所以此时遍历顺序即为出栈顺序
		Node cur = head.next;
		while (cur != null){
			System.out.println(cur + "\t");
			cur = cur.next;
		}
		System.out.println();
		return;
	}
}




class Node {
	public int data;
	public Node next;

	public Node() {}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node{" +
				"data=" + data +
				'}';
	}
}
