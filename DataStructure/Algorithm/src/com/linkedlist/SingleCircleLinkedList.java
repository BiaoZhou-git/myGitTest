package com.linkedlist;

import java.awt.*;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2019/12/29-17:56
 */
//以约瑟夫问题为例
//以无头结点的循环单向链表为例
public class SingleCircleLinkedList {
	//创建一个first节点，当前没有编号，无头结点
	private Boy first = null;

	//添加节点，构建一个环形链表
	public void addBoy(int nums) {
		//nums做个数据检验
		if(nums < 1) {
			System.out.println("nums的值不正确！");
			return;
		}
		
		//执行到此说明，可以用来创建nums个节点的单向循环链表
		Boy curBoy = null;//辅助指针，用来构建环形链表
		for (int i = 1; i <= nums; i++) {//创建nums个节点
			Boy boy = new Boy(i);
			if (i == 1){//一个节点的循环链表
				first = boy;
				first.next = first;//构成循环
				curBoy = first;//让curBoy指向第一个小孩，first指针是始终不会变化的
			}
			//执行到此，说明链表中不止一个元素
			boy.next = curBoy.next;
			curBoy.next = boy;
			curBoy = curBoy.next;
		}
	}

	//遍历当前的循环链表
	public void showBoy() {
		//判空
		if(first == null) {
			System.out.println("单向循环链表为空，打印失败！");
			return;
		}
		//执行到此，说明链表不为空
		Boy cur = first;//设置一个辅助指针
		while (true) {//不一定都是先判断退出后操作，也可以是操作后判断退出
			//这里就是，先打印输出，后判断退出。若是反了顺序，则会少打印最后一个元素
			System.out.printf("小孩的编号为:%d\t", cur.getNo());
			if(cur.next == first) {
				break;
			}
			cur = cur.next;
		}
		System.out.println();
		return;
	}

	//根据用户的输入计算出出圈的顺序

	/**
	 *
	 * @param nums:链表中有多少个元素
	 * @param startNum:从第几个元素开始数
	 * @param countNum:数几个
	 */
	public void countBoy(int nums, int startNum, int countNum) {
		//先对数据进行简单校验
		if(first == null) {
			System.out.println("链表为空，不可执行出圈！");
			return;
		}

		if(startNum < 1 || startNum > nums)  {
			System.out.println("参数输入有误，不可执行出圈！");
			return;
		}

		//因为涉及到一个删除节点的操作，所以需要设置一个辅助指针helper,帮助小孩出圈
		//执行到此说明链表中至少有一个节点
		//初始分helper指针
		Boy helper = first;
		while (helper.next != first) {//保证helper始终在first之前的一个
			helper = helper.next;
		}

		//指针移动到指定的初始位置，指针应该移动startNum-1次
		for (int i = 0; i < startNum-1; i++) {
			first = first.next;
			helper = helper.next;
		}

		//小孩开始出圈，当小孩报数时，让first和helper指针同时移动mcountNum-1次，此时first指针正好指向，要出圈的小孩
		//这里进行循环，直到圈中只有一个小孩
		while (true) {
			if(first == helper){//说明链表中只有一个节点
				break;
			}
			else {
				//让first和helper指针同时移动mcountNum-1次，此时first指针正好指向，要出圈的小孩
				for (int j = 0; j < countNum-1; j++) {
					first = first.next;
					helper = helper.next;
				}
			}
			//这时first指向出圈的小孩
			System.out.printf("小孩%d出圈\n", first.getNo());
			//出圈
			first = first.next;
			helper.next = first;
		}
		//最后一个小孩出圈
		System.out.printf("最后留在圈中小孩编号%d\n", first.getNo());

		first = null;

	}

}

//创建Boy类，表示一个节点
class Boy {
	private int no;
	public Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}
