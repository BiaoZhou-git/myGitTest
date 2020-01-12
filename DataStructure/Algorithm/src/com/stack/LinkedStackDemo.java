package com.stack;

import java.util.Scanner;

/**
 * @author tiko
 * @createDate 2019/12/30-9:37
 */
public class LinkedStackDemo {
	public static void main(String[] args) {

		LinkedStack linkedStack = new LinkedStack(4);

		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show:显示栈元素");
			System.out.println("push:入栈");
			System.out.println("pop:出栈");
			System.out.println("exit:退出");
			System.out.print("请输入你的选择:");
			key = scanner.next();
			System.out.println();

			switch (key) {
				case "show":
					linkedStack.list();
					break;
				case "push":
					System.out.println("请输入一个元素:");
					int value = scanner.nextInt();
					Node node = new Node(value);
					linkedStack.push(node);
					break;
				case "pop":
					try {
						int res = linkedStack.pop();
						System.out.println("出栈的数据是:" + res);
					} catch (Exception e) {
						System.out.println("栈空，无需遍历");
					}
					break;
				case "exit":
					scanner.close();
					loop = false;
					System.out.println("程序退出！");
					break;
				default:
					break;
			}
		}

	}
}

