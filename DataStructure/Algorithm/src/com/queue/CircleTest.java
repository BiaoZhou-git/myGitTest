package com.queue;

import java.util.Scanner;

/**
 * @author tiko
 * @createDate 2019/12/24-10:06
 */
public class CircleTest {
	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(4);//说明，设置为4，其队列的有效数据个数为3
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("--------------");
			System.out.println("s(show)");
			System.out.println("p(push)");
			System.out.println("o(pop)");
			System.out.println("h(get)");
			System.out.print("输入你的选择:");

			int num;
			char c = scanner.next().charAt(0);
			switch (c) {
				case 's':
					queue.shoｗ();
					break;
				case 'p':
					System.out.print("输入一个整数:");
					int val = scanner.nextInt();
					try {
						queue.push(val);
					}
					catch (Exception e){
						System.out.println("队满无法插入");
					}

					break;
				case 'o':
					try {
						num = queue.pop();
						System.out.println("pop:" + num);
					}catch (Exception e) {
						System.out.println("队空无法取值");
					}

					break;
				case 'g':
					try {
						num = queue.headOfQueue();
						System.out.println("head of queue:" + num);
					}catch (Exception e) {
						System.out.println("队空无法取值");
					}

				default:
					break;
			}

		}


	}
}

