package com.queue;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author tiko
 * @createDate 2019/12/23-19:45
 */
public class Test {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("--------------");
			System.out.println("s(show)");
			System.out.println("p(push)");
			System.out.println("o(pop)");
			System.out.println("g(get)");
			System.out.print("输入你的选择:");

			int num;
			char c = scanner.next().charAt(0);
			switch (c) {
				case 's':
					queue.show();
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
						num = queue.getFront();
						System.out.println("pop:" + num);
					}catch (Exception e) {
						System.out.println("队空无法取值");
					}

				default:
					break;
			}

		}


	}
}
