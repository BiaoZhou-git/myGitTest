package com.stack;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.Stack;
//在循环中，如果涉及到索引的变动或指针的变动时，要注意在循环退出时的可能导致的越界异常和空指针异常
//越界异常的判定和空指针异常的判定应再其他判定语句之前。因为逻辑运算的短路
/**
 * @author tiko
 * @createDate 2019/12/30-15:51
 */
//将一个中缀表达式转成后缀表达式
//1. 1+((12+3)*4)-5 -> 1 12 3 + 4 * + 5 -
//2.因为直接对str进行操作，不方便，因此现将"1+((2+3)*4)-5"中缀的表达式对应的list
	//既"1+((2+3)*4)-5"=>ArrayList [1,+,(,(,2,+,3,),*4,),-,5]
//3.将得到的中缀表达式对应的list=>后缀表达式对应的list
	//既[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] =>[1, 2, 3, +, 4, *, +, 5, -]
public class InfixToSuffix {
	public static void main(String[] args) {
		List<String> list = toInfix("1+((2+3)*4)-5");
		System.out.println(list);
		List<String> suffixStr=  infixParseSuffixList(list);
		System.out.println(suffixStr);
		int result = PolandNotation.calculator(suffixStr);
		System.out.println(result);


	}

	//1+((2+3)*4)-5 => [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
	public static List<String> toInfixExpression(String str) {
		List<String> ls = new ArrayList<>();
		int index = 0;//用来变量字符串
		String s;//用来实现多位数的拼接
		char ch = ' '; //每遍历到一个字符，就放入ch中

		do{
			//如果读到的字符不是数字(char) [判断一个字符是不是非数字比判断一个字符是不是数字要简单一点。因为作为数字，可能会多位数字]
			if ((ch=str.charAt(index)) < 48|| (ch=str.charAt(index))>57) {//s.charAt()不是'0'-'9';
				//说明是运算符
				ls.add(String.valueOf(ch));//入栈
				index++;
			}else {//说明遇到数字了(其至少是一位数字)，需要考虑多位数的问题
				//索引未越界且在char在数字范围内。拼接
				s = "";
				//当前char是数字，且未越界
				//不过不加溢出判断，char指向且为数字的话，index+1的话，就会越界，此时str.charAt(index)抛出溢出异常
				while(index < str.length() && ((ch=str.charAt(index)) >= 48 && (ch=str.charAt(index))<=57 ) ) {
					s += ch;//拼接
					index++;
				}
				//执行到此，说明多位数已经找到
				ls.add(s);
			}
		}while (index < str.length());
		return ls;
	}

	public static List<String> toInfix(String originStr) {
		List<String> ls = new ArrayList<>();
		int index = 0;
		char ch = ' ';
		String concatStr = "";
		while (index < originStr.length()){
			if((ch=originStr.charAt(index))<48 || (ch=originStr.charAt(index))>57) {
				ls.add(String.valueOf(ch));
				index++;
			}else {
				while(index < originStr.length() && ((ch=originStr.charAt(index))>=48 && (ch=originStr.charAt(index))<=57)){
					concatStr += ch;
					index++;
				}
				ls.add(concatStr);
				concatStr = "";
			}
		}
		return ls;

	}

	//[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] =>[1, 2, 3, +, 4, *, +, 5, -]
	//中缀list转后缀list
	public static List<String> infixParseSuffixList(List<String> originList) {
		//定义两个栈
		//符号栈
		Stack<String> operStack = new Stack<>();
		//说明：因为numStack这个栈，在整个过程中，没有pop操作，且后面也要逆序输出。->没必要创建。直接用一个ArrayList接收就好
		//Stack<String> numStack = new Stack<>();
		List<String> list = new ArrayList<>();

		//遍历originList
		for (String s : originList) {
			if(s.matches("\\d+")){//如果是一个数字
				list.add(s);//直接赋值
			}else if (s.equals("(")) {//如果是左括号
				operStack.add(s);//入栈
			}else if (s.equals(")")) {
				//如果是")"，则以此弹出operStack的运算符，并放入list中，直到在operStack中遇到"("，此时operStack再pop，消除一对括号
				while (!operStack.peek().equals("(")) {//只要在operStack中未遇到"("，一直进行如下操作
					list.add(operStack.pop());
				}
				operStack.pop();//!!!!!弹出左括号，消除一对括号
			}else {//以下就是操作，正常的运算符（+，-，*，/）
				//当item(s)的运算符的优先级小于或者等于operStack栈顶的运算符的优先级
				//将operStack栈顶的元素弹出并加入list中
				//问题是，确实一个运算符优先级比较的方法
				while (operStack.size()!=0 && Operation.getPriorityLevel(s) <= Operation.getPriorityLevel(operStack.peek())) {
					list.add(operStack.pop());
				}
				//结束后，需要将item入栈
				operStack.push(s);
			}
		}

		//将operStack中的运算符以此加入list即可
		while (operStack.size() != 0) {
			list.add(operStack.pop());
		}

		return list;
	}
}

//一个用来比较运算符优先级比较的类
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	//写一个方法，返回值对应的优先级数字
	public static int getPriorityLevel(String operation) {
		int res = 0;
		switch(operation) {
		    case "+":
		    	res = ADD;
		        break;
			case "-":
				res = SUB;
				break;
			case "*":
				res = MUL;
				break;
			case "/":
				res = DIV;
				break;
		    default:
		        break;
		}
		return res;
	}
}