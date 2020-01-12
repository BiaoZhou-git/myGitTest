package com.stack;

import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author tiko
 * @createDate 2019/12/29-20:30
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(4);


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
					arrayStack.list();
					break;
				case "push":
					System.out.println("请输入一个元素:");
					int value = scanner.nextInt();
					arrayStack.push(value);
					break;
				case "pop":
					try {
						int res = arrayStack.pop();
						System.out.println("出栈的数据是:" + res);
					} catch (Exception e) {
						System.out.println("栈空无法，无法进行出栈操作！");
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
