package com.linkedlist;

/**
 * @author tiko
 * @createDate 2019/12/26-14:35
 */
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("双向链表的测试---");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

		DoubleNode doubleNode1 = new DoubleNode(1, "小花", "花");
		DoubleNode doubleNode2 = new DoubleNode(5, "小名", "名");
		DoubleNode doubleNode3 = new DoubleNode(3, "小月", "月");
		DoubleNode doubleNode4 = new DoubleNode(4, "小新", "新");
		DoubleNode doubleNode5 = new DoubleNode(5, "小新", "新");
		DoubleNode doubleNode6 = new DoubleNode(10, "小新", "新");
//		doubleLinkedList.list();
//		doubleLinkedList.tailAdd(doubleNode1);
//		doubleLinkedList.tailAdd(doubleNode2);
//		doubleLinkedList.tailAdd(doubleNode3);
//		doubleLinkedList.headAdd(doubleNode4);
//		doubleLinkedList.list();
//
//		doubleLinkedList.del(1);
//		doubleLinkedList.list();
//		doubleLinkedList.del(3);
//		doubleLinkedList.list();
//		doubleLinkedList.update(doubleNode5);
//		doubleLinkedList.list();
//		doubleLinkedList.update(doubleNode6);
//		doubleLinkedList.list();

		DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
		doubleLinkedList2.addByOrder2(doubleNode2);
		doubleLinkedList2.addByOrder2(doubleNode1);
		doubleLinkedList2.addByOrder(doubleNode6);
		doubleLinkedList2.list();

	}
}
