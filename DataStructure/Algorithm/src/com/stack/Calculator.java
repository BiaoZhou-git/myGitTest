package com.stack;

import javax.management.relation.InvalidRelationIdException;
import javax.security.auth.callback.CallbackHandler;
import java.util.logging.SocketHandler;

/**
 * @author tiko
 * @createDate 2019/12/30-10:30
 */
public class Calculator {
	public static void main(String[] args) {
		//表达式
		String expression = "30+6*6-20";//仍存问题，如何处理多位数呢？

		//创建两个栈，数栈，符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		//定义相关变量
		int index = 0;//表达式扫描器
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//将每次扫描得到的char保存到ch中

		//将表达式一次性转化成字符数组
		char[] chars = expression.toCharArray();
		String keepNum = "";//用于拼接多位数
		while (true) {
			//以此得到expression的每个字符
			ch = chars[index];
			if (operStack.isOper(ch)) {//如果是运算符的话
				//判断当前符号栈是否为空
				if (!operStack.isEmpty()) {//如果不为空
					//不为空，比较优先级
					//当前运算符的优先级小于或等于operStack中栈顶元素的优先级时
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//结果入数栈
						numStack.push(res);
						operStack.push(ch);
					} else {//当前运算符的优先级大于operStack中栈顶元素的优先级时，直接入operStack
						operStack.push(ch);
					}
				} else {//如果为空，直接入栈
					operStack.push(ch);
				}
			} else {//如果是数值，则入数栈
				//以下代码无法解决多位数的问题
//				numStack.push(ch -48);//char类型应该转int型 '0'->48
				//分析思路
				//1.当处理多位数时，不能发现一个数就直接入栈，因为多位数
				//2.在处理时，需要看expression的表达式的index后在看一位，如果是数则继续进行扫描，直至到运算符结束
				//因此需要定义一个字符串变量用于拼接

				//处理多位数
				keepNum += ch;

				//如果ch已经是expression的最后一位，则直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					//判断下一个字符是不是数字，如果是数字则继续拼接，如果是运算符则此时拼接的数字入栈
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						//如果是运算符，则入栈
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";//keepNum置空！！！！
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}

		}

		while (true) {
			if (operStack.isEmpty()) {//如果符号栈为空，说明数栈中只有一个最终的结果
				break;
			}
			//执行到此，说明栈中还有要进行计算的步骤
			//计算步骤如下
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			//结果入数栈
			numStack.push(res);
		}
		//执行到此，数栈中只有一个元素
		System.out.printf("expression:%s=%d", expression, numStack.pop());
	}
}

//用数组模拟栈，top指向栈顶，且初始值设为-1
class ArrayStack2 {
	private int maxSize;//栈的大小
	private int[] stack;//数组模拟栈，数据放在该栈内
	private int top = -1;//top表示栈顶，初始值为-1
	private int size = 0;//栈中元素个数

	//创建一个容量为maxSize大小容量的栈
	public ArrayStack2(int num) {
		this.maxSize = num;
		stack = new int[this.maxSize];
	}

	//判栈空
	public boolean isEmpty() {
		return top == -1;
	}

	//判栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	public void push(int value) {
		//压栈，先判满
		if (isFull()) {
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
		if (isEmpty()) {
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
		if (isEmpty()) {
			System.out.println("栈空！无法遍历...");
			return;
		}

		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\t", i, stack[i]);
		}
		System.out.println();
		return;
	}

	//返回运算符的优先级，优先级由程序员来确定，优先级使用数字表示
	//这里规定，数字越大，则优先级越高
	public int priority(int symbol) {
		if (symbol == '*' || symbol == '/') {
			return 1;
		} else if (symbol == '+' || symbol == '-') {
			return 0;
		} else {//符号有误,返回-1
			return -1;
		}
	}

	//判断当前符号是数字还是运算符，这里只进行简单的加减乘除运算
	public boolean isOper(char oper) {
		return oper == '+' || oper == '-' || oper == '*' || oper == '/';
	}

	//简单的二元运算
	//假定都是理性人，不会异常输入
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {//由分析得，oper的顺序为次栈顶元素操作栈顶元素
			case '+':
				res = num2 + num1;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num2 * num1;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}

	public int peek() {
		return stack[top];
	}

	public int getSize() {
		return size;
	}
}
