package com.hashtab;

import java.text.BreakIterator;

/**
 * @author tiko
 * @createDate 2020/1/10-9:22
 */
public class HashTab {
	private EmpList[] empLists;
	private int size;//用于初始化hashTable中数组大小

	public HashTab(int size) {
		this.size = size;
		empLists = new EmpList[this.size];//这里只是分配了空间，默认为null
		for (int i = 0; i < size; i++) {
			empLists[i] = new EmpList();//这里进行初始化，让数组中的元素指向链表的指针
		}
	}
	//定义hash的散列函数， 这里使用取余法
	private int hashFun(int num) {
		return num % size;
	}

	//通过hashTab来进行添加Emp节点
	public void add(Emp node) {
		int id = node.id;
		empLists[hashFun(id)].add(node);
		return;
	}

	public void addById(Emp node) {
		int id = node.id;
		empLists[hashFun(id)].addById(node);
		return;
	}

	//通过hashTable来打印信息
	public void list() {
		for (int i = 0; i < size; i++) {
			empLists[i].list(i);
		}
	}

}

//定义一个节点类
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

//定义一个记录Emp的链表（不带头结点）
class EmpList {
	private Emp head = null;//不带头结点

	public EmpList() {//这里只是显式给出无参构造函数
	}

	//添加Emp,尾插法
	public void add(Emp node) {
		Emp p = head;
		if (p == null) {//链表中无元素时,直接添加并返回
			p = node;
			head = p;
			return;
		}

		//执行到此，说明链表中不止一个元素

		while (true) {
			if(p.next == null) {
				break;
			}
			p = p.next;
		}
		p.next = node;
		return;
	}

	//addByID

	//注意不带头结点和带头结点时元素的插入问题
	//不带头结点的顺序插入，需要单独考虑插入的元素为第一个元素或是第二个元素的情况
	public void addById(Emp node) {
		Emp p = head;
		if (head == null) {//插入的元素是第一个元素 [] 1
			head = node;
			return;
		}

		//插入的元素如果是第二个元素 [1] 2 ; [3] 2
		if (head.next == null){
			if (head.id < node.id) {
				head.next = node;
				return;
			}else if(head.id == node.id) {
				System.out.println("该id值已经存在，无法插入！");
				return;
			}else {
				node.next = head;
				head = node;
				return;
			}

		}

		//执行到此说明，链表中至少有两个元素
		//[2, 42] 5; [45, 78] 99
		while (true) {//注意循环体里面的执行顺序
			if (p.next == null ) {//说明链表已经到最后了
				break;
			}
			if (p.next.id > node.id) {
				node.next = p.next;
				p.next = node;
				return;
			}
			if (p.next.id == node.id) {
				System.out.println("已经存在该id值，无法插入！");
				return;
			}
			p = p.next;
		}
		p.next = node;



	}

	//打印Emp
	public void list(int num) {
		System.out.print("第" + num + "链表信息为：");
		Emp p = head;
		if( p == null) {
			System.out.println("链表为空!");
			return;
		}

		//执行到此，说明链表中至少有一个元素
		while (true) {
			System.out.print(p.id+ "-" + p.name + ";");
			if(p.next == null) {
				break;
			}
			p = p.next;
		}
		System.out.println();
		return;
	}


}
