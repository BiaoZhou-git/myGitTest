package com.stack;

import java.util.*;

/**
 * @author tiko
 * @createDate 2019/12/30-14:15
 */
/*
逆波兰表达式
前提说明：
1.输入一个逆波兰表达式(后缀表达式)，使用Stack，计算结果
2.支持小括号和多位整数（主要针对数据结构，进行了简化）
3.中缀表达式转后缀表达式，后面再说

重点：
1.逆波兰表达式的运算
2.正则表达式的简单使用

未解决问题：
1.如何从中缀表达式转化成后缀表达式
 */
public class PolandNotation {
	public static void main(String[] args) {
		//先定义一个后缀表达式
		//(3+4)*5-6->3 4 + 5 * 6 -
		//为了方便，数字和符号之间用空格隔开
		//4 * 5 - 8 + 6 + 8 / 4 -> 4 5 * 8 - 6 + 8 4 / + =>20
		String suffixExpression = "4 5 * 8 - 6 + 8 4 / +";
		System.out.println(suffixExpression);
		List<String> rpn = rpnList(suffixExpression);
		System.out.println(rpn);
		System.out.println("计算结果是:"+calculator(rpn));
	}

	//使用一个ArrayList来存储该表达式
	public static List<String> rpnList(String suffixExpression) {
		List<String> list = new ArrayList<>();

		String[] strs = suffixExpression.split(" ");
		for (String str : strs) {
			list.add(str);
		}
		return list;
	}

	//使用逆波兰表达来进行计算 [3, 4, +, 5, *, 6, -]
	public static int calculator(List<String> list) {
		//使用一个栈来进行操作
		Stack<String> stringsStack = new Stack<>();
		//遍历list，若是数字则进行入栈，如果是运算符，则进行计算，计算之后则进行在入栈。直至最后一运算符处理完毕
		for (String s : list) {
			if(s.matches("\\d+")){//使用正则表达式，判断是否是数组，\\d表示数字，+表示至少一个数字
				stringsStack.push(s);
			}else {//说明当前的符号是运算符,运算完之后，结果入栈
				int operNum2 = Integer.parseInt(stringsStack.pop());
				int operNum1 = Integer.parseInt(stringsStack.pop());

				int res = 0;
				switch(s) {
				    case "+":
				    	res = operNum1 + operNum2;
				        break;
					case "-":
						res = operNum1 - operNum2;
						break;
					case "*":
						res = operNum1 * operNum2;
						break;
					case "/":
						res = operNum1 / operNum2;
						break;
				    default:
				    	new RuntimeException("运算符有误！");
				        break;
				}
				stringsStack.push("" + res);//因为泛型为string，所以这里需要转换一下格式
			}
		}
		//for结束，此时栈中的元素即为结果
		return Integer.parseInt(stringsStack.pop());

	}

}
