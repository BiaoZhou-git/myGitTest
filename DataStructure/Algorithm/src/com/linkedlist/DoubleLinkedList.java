package com.linkedlist;


import java.lang.ref.SoftReference;

/**
 * @author tiko
 * @createDate 2019/12/26-13:15
 */
public class DoubleLinkedList {
	//定义双向链表的头结点
	private DoubleNode head = new DoubleNode(-1, "", "");

	//返回指向头结点的指针
	public DoubleNode getHead() {
		return head;
	}

	//遍历显示双向链表中的元素
	public void list() {
		//判空
		if(head.next == null) {
			System.out.println("双向链表为空，不能打印！");
			return;
		}
		//执行到此，说明双向链表不为空
		DoubleNode cur =  head.next;
		while (cur != null)  {//遍历，直到cur指向null
			System.out.print(cur  + "\t");
			cur = cur.next;//指针后移
		}
		System.out.println();
	}

	//双向链表的尾插法
	public void tailAdd(DoubleNode node){
		DoubleNode p = head;
		while (p.next != null) {//直到p.next为空的时候结束
			p = p.next;
		}
		//此时，p指向最后一个节点
		//将node插入链表中
		p.next = node;
		node.pre = p;
	}

	//双向链表头插法
	public void headAdd(DoubleNode node) {
		//判空
		if(head.next == null) {//此时链表为空，只需要将node挂在头结点之后即可
			head.next = node;
			node.pre = head;
			return;
		}
		//执行到此，说明链表中至少存在一个节点
		DoubleNode p = head;
		DoubleNode q = head.next;
		//先保留原p,q连接关系
		node.next = p.next;
		node.pre = q.pre;
		//再修改
		p.next = node;
		q.pre = node;
		return;
	}

	//双向链表中修改(依靠no)
	//规则：若链表中已存在no对应的node则，修改否则返回不可修改的提示信息即可
	public void update(DoubleNode node) {
		//分为三种情况：1.链表为空，函数返回；2.找到修改，函数返回；3.遍历结束未找到，函数返回
		//判空
		if(head.next == null) {
			System.out.println("链表为空，不可修改！");
			return;
		}

		//执行到此说明链表中至少有一个元素。
		DoubleNode cur = head.next;
		while (cur != null) {
			if(cur.no == node.no) {//说明找到了，进行修改
				cur.name = node.name;
				cur.nickname = node.name;
				return;
			}
			cur = cur.next;//指针后移
		}

		//执行到此，说明遍历完链表也没有找到
		//给出提示信息，并返回void
		System.out.println("链表中无该对应no编号的节点，无法修改！");
		return;
	}

	//双向链表的删除
	//规则：依据no对应的编号来删除
	public void del(int no) {
		//判空
		if(head.next == null) {
			System.out.println("双向链表为空，删除失败！");
			return;
		}
		//执行到此，说明链表至少有一个节点
		DoubleNode cur = head.next;
		Boolean flag = false;//记录是否找到对应no编号的节点，若未找到，值为false，找到为true
		while (true) {
			//以下两个if若颠倒顺序，可能会出现空指针异常
			if (cur == null) {//指针指向最后一节点的指针域，且其指针域指向null
				System.out.println("链表中未找到对应no编号的节点，删除失败！");
				return;
			}
			if(cur.no == no){//找到了
				flag = true;//修改记录标志
				break;//退出循环
			}
			cur = cur.next;
		}
		if(flag) {//找到了，进行修改
//			if(cur.next != null){//若cur指向的节点不是最后一个节点
//				cur.pre.next = cur.next;
//				cur.next.pre = cur.pre;
//				return;
//			}else {	//若cur指向的节点是最后一个节点
//				cur.pre.next = null;
//				cur.pre= null;
//			}
			cur.pre.next = cur.next;
			if(cur.next != null) {//cur不是最后一个节点;若cur为最后一节点，执行以下操作，会出现空指针异常
				cur.next.pre = cur.pre;
			}
		}else {
			System.out.println("未找到对应的no编号的节点，删除失败！");
			return;
		}

	}

	//按照顺序添加节点
	//按照编号no的升序插入
	public void addByOrder(DoubleNode node) {
		//保存头结点
		DoubleNode p = head;
		//插入时，需要考虑前驱；temp为添加位置的前一个位置
		boolean flag = false;//flag标志添加的编号是否存在，否则插入不了
		while(true) {
			//因遍历结束引起循环的退出
			if(p.next == null){//p已经指向最后一个节点了或为一个空链表
				break;
			}

			//由值的比较引起循环的退出
			if(p.next.no > node.no ){//找到指定的要插入的位置，注意这里是p.next不是p;
				// 若p.next.no为空指针异常，则抛出异常
				break;
			} else if (p.next.no == node.no) {//已经存在该值了，不允许插入
				System.out.println("该值已存在！");
				flag = true;//说明编号存在
				break;
			}
			//遍历
			p = p.next;//后移，遍历当前链表
		}
		if(flag){//说明编号存在，不允许插入
			System.out.println("该值已存在，不允许再插入no值:" + node.no);
			return;
		}else {//允许插入
			if(p.next == null) {//要插入位置在最后一个
				p.next = node;
				node.pre = p;
			} else { //要插入位置不在最后
				DoubleNode q = p.next;

				node.next = p.next;
				node.pre = q.pre;

				p.next = node;
				q.pre = node;
			}
		}
	}

	public void addByOrder2(DoubleNode node) {

		DoubleNode preCur = head;
		DoubleNode cur = head.next;

		while (true) {
			if (cur == null){
				break;
			}

			if (cur.no > node.no && cur != null){
				break;
			}

			cur = cur.next;
			preCur = preCur.next;
		}

		//如果cur==null，那么cur.no就会抛出空指针异常
		//用链表来操作数据的时候，得考虑一下前驱
		if(cur == null){
			preCur.next = node;
			node.pre = preCur;
			return;
		} else {
			node.next = preCur.next;
			node.pre = cur.pre;
			preCur.next = node;
			cur.pre = node;
			return;
		}


	}
}


//创建双向链表中的节点
class DoubleNode {
	//数据域
	public int no;
	public String name;
	public String nickname;

	//指针域
	public DoubleNode pre = null;
	public DoubleNode next = null;

	public DoubleNode() {
	}

	public DoubleNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "DoubleNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}
}
