package com.hashtab;

import java.util.Scanner;

/**
 * @author tiko
 * @createDate 2020/1/10-9:52
 */
public class HashTableDemo {
	public static void main(String[] args) {
		//定义一个hashTab
		HashTab hashTab = new HashTab(7);

		Scanner scanner = new Scanner(System.in);

		//定义一个循环出标志
		boolean isExit = false;
		while (!isExit) {
			//定义一个菜单
			System.out.println("add:添加节点信息");
			System.out.println("addB:顺序添加节点信息");
			System.out.println("list：打印hashTable信息");
			System.out.println("exit:退出");
			//接收用户的选择
			String choice = scanner.next();
			//根据用户的选择进行相应的处理
			switch(choice) {
			    case "add":
					System.out.println("输入id：");
			    	int id = scanner.nextInt();
					System.out.println("输入姓名：");
			    	String name = scanner.next();
			    	Emp node = new Emp(id, name);
			    	hashTab.add(node);
			        break;
				case "addB":
					System.out.println("输入id：");
					int id2 = scanner.nextInt();
					System.out.println("输入姓名：");
					String name2 = scanner.next();
					Emp node2 = new Emp(id2, name2);
					hashTab.addById(node2);
					break;
				case "list":
					hashTab.list();
					break;
				case "exit":
					isExit = true;
					break;
			    default:
			        break;
			}
		}
		scanner.close();


	}
}
