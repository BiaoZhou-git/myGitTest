package com.linkedlist;

/**
 * @author tiko
 * @createDate 2019/12/24-17:40
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		Node node1 = new Node(1, "小李", "李");
		Node node2 = new Node(3, "小强", "强");
		Node node3 = new Node(3, "小花", "花");
		Node node4 = new Node(2, "小朱", "朱");
		Node node5 = new Node(4, "小云", "云");
		Node node6 = new Node(1, "小云", "云");
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		singleLinkedList.add(node1);
		singleLinkedList.add(node2);
		singleLinkedList.addByOrder(node3);
		singleLinkedList.addByOrder(node4);
		singleLinkedList.addByOrder(node5);
		System.out.println(singleLinkedList.getLength());
		singleLinkedList.update(node6);

		singleLinkedList.list();
		System.out.println(singleLinkedList.getLength());
		singleLinkedList.del(1);
//		singleLinkedList.del(4);
		singleLinkedList.list();
		System.out.println(singleLinkedList.getLength());

		Node q = singleLinkedList.findLastIndexNode(2);
		System.out.println(q);


		System.out.println("原链表:");
		singleLinkedList.list();
//		System.out.println("反转后链表");
//		singleLinkedList.reversed();
//		singleLinkedList.list();

		System.out.println("反向打印:");
		singleLinkedList.reversedPrint();
		System.out.println("原链表:");
		singleLinkedList.list();



	}
}
