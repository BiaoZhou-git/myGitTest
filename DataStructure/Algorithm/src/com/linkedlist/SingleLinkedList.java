package com.linkedlist;

import java.util.Stack;

/**
 * @author tiko
 * @createDate 2019/12/24-17:10
 */
public class SingleLinkedList {//带头结点
	//先初始化一个头结点，头结点不动,，不存储具体的数据
	private Node head = new Node(0,"","");

	//构造函数，不指定，可以使用系统自带的无参构造函数

	//添加节点到单向链表
	//尾插法
	public void add(Node node) {
		//因为head不能动，需要一个辅助node指向head（这个很重要，保证head始终指向头结点）
		Node temp= head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
	}

	//根据no的大小来插入指定的位置，
	//如果有这个no大小的节点，则添加失败，并给出显示
	public void addByOrder(Node node) {
		//保存头结点
		Node p = head;
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
		}else {
			node.next = p.next;
			p.next = node;
			System.out.println("add by order access!");
		}

	}

	//修改节点的信息，根据no编号来修改，即no编号不能改
	//说明
	//1.根据node的no来修改
	public void update(Node node) {
		Node p = head;
		//判空
		if(p.next == null){//空链表
			System.out.println("链表为空，无法修改！");
			return;
		}

		//执行到这里，说明表不为空

		//用来寻找被修改的节点
		//设置辅助变量temp
		Node temp = p.next;
		boolean flag = false;//用来表示是否找到要修改的节点
		while(true) {
			if(temp == null){//说明temp到最后一个节点的下一个空节点
				break;
			}
			if(temp.no == node.no) {
				flag = true;//找到修改的节点了
				break;
			}
			temp = temp.next;
		}

		//根据flag判断是否找要修改的节点
		if(flag) {
			temp.name = node.name;
			temp.nickName = node.nickName;
			System.out.println("update access！");
		} else {//没有找到
			System.out.printf("没有找到no为%d的节点，无法修改!", node.no);
			System.out.println();
		}

	}


	//删除节点
	//1.找到待删除节点的前一个节点
	//2.temp.next.no 和需要删除的节点的no比较
	public void del(int no) {
		Node p = head;
		boolean flag = false;//用来标记是否找到对应no的节点
		while (true){
			if(p.next == null){//p指向最后一个节点，因为此时p.next==null
				//p最为删除节点的前驱，若是前驱指向最后一个节点，说明没找到对应no的节点
				//判空也适用
				break;
			}
			if(p.next.no == no){
				flag = true;
				break;
			}
			p = p.next;
		}

		if (flag) {//说明找到了，被删除的节点
			p.next = p.next.next;
			System.out.println("该节点删除成功！");
			return;
		}else {
			System.out.println("未找到对应no的节点，无法删除");
			return;
		}


	}



	//显示列表
	public void list() {
		//判列表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//执行到这一步，说明链表中至少有一个元素
		//以为头结点不能动，需要一个头结点
		Node p = head.next;
		while (true) {
			if(p == null) {
				break;
			}
			System.out.print(p + "\t" );
			p = p.next;
		}
		System.out.println();
	}

	//统计有多少个有效数字
	public  int getLength() {
		if(head.next == null) {
			return 0;
		}
		Node p = head.next;
		int len = 0;
		while (true) {
			if(p == null){
				break;
			}
			len++;
			p = p.next;
		}
		return len;
	}

	//返回导数第k个元素
	public Node findLastIndexNode(int k) {
		Node p = head.next;
		if(p == null) {
			System.out.println("链表为空，无法返回节点！");
			return null;
		}
		if(k > getLength()|| k <= 0){
			System.out.println("越界！");
			return null;
		}

		int i = getLength() - k;
		for (int j = 0; j < i; j++) {
			p = p.next;
		}
		return p;
	}

	//单链表的反转
	//基本思想：原链表遇到一节点就将该节点头插法加入到新链表中（只需要创建一个新的头结点而已）
	public void reversed() {
		//判空或者只有一个节点
		if(head.next == null || head.next.next == null) {
			System.out.println("链表为空或只有一个节点，不需反转");
			return;
		}

		//执行到此，说明链表中元素至少有两个
		Node reversedNode = new Node(-1,"","");//新的头结点
		Node cur = head.next;//记录原链表中的当前的节点
		Node next = null;

		while (true){
			if(cur == null) break;//cur为空，遍历结束
			//执行到此，说明反转
			//头插法，插入cur，反序
			next = cur.next;
			cur.next = reversedNode.next;//这里已经要修改cur的指针域了，所以原cur的指针域应该要保留
			reversedNode.next = cur;
			cur = next;
		}
		//更新原头结点的指向
		head.next = reversedNode.next;
	}

	//逆序打印，但不破坏原先的链表的结构
	//巧妙的方法，创建一个栈，遇到一个节点，就压入栈，压栈完毕，依次弹出，即为逆序
	public void reversedPrint() {
		if(head.next == null) {
			System.out.println("链表为空，不能打印！");
		}
		//执行到此说明，链表不为空
		Node cur = head.next;
		Stack<Node> nodes = new Stack<>();//创建一个栈，用来收集链表中的节点
		while(cur != null){
			nodes.push(cur);//入栈
			cur = cur.next;//指针后移，遍历
		}

		while (!nodes.empty()) {
			System.out.print(nodes.pop() + "\t");
		}
		System.out.println();
	}

}

//定义一个节点Node，代表一个节点
class Node {
	public int no;
	public String name;//数据域
	public String  nickName;
	public Node next = null;//指针域

	public Node(int no, String  name, String str){
		this.name = name;
		this.no = no;
		nickName = str;
	}

	//为显示方便，重写tostring()


	@Override
	public String toString() {
		return "Node{" +
				"no=" + no +
				", name=" + name +
				", nickName='" + nickName + '\'' +
				'}';
	}
}