package com.tree;

/**
 * @author tiko
 * @createDate 2020/1/11-17:19
 */
public class BinaryTreeDemo {
	public static void main(String[] args) {
		//创建一个树
		BinaryTree binaryTree = new BinaryTree();

		Node node1 = new Node(10, "名");
		Node node2 = new Node(2, "花");
		Node node3 = new Node(11, "化");
		Node node4 = new Node(3, "强");


		binaryTree.insert(node1);
		binaryTree.insert(node3);
		binaryTree.insert(node2);
		binaryTree.insert(node4);


		//测试
		System.out.println("前序遍历：");
		binaryTree.preOrder(binaryTree.getRoot());
		System.out.println("中序遍历:");
		binaryTree.infixOrder(binaryTree.getRoot());
		System.out.println("后序遍历:");
		binaryTree.postOrder(binaryTree.getRoot());
		System.out.println("查找关键字key");
		System.out.println(binaryTree.SearchByKey(13,binaryTree.getRoot()));
	}
}
