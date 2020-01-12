package com.tree;

import javax.sound.midi.Soundbank;

/**
 * @author tiko
 * @createDate 2020/1/11-16:19
 */
public class BinaryTree {
	private Node root;//指向当前树，根节点

	public BinaryTree() {
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return this.root;
	}

	//插入节点
	public void insert(Node node) {
		if(root == null) {//如果为空树，则将被插入节点作为根节点
			root = node;
			return;
		}
		//执行到此，说明树中至少有一个元素
		Node currentNode = root;//记录当前节点
		Node preNode;//记录currentNode的父节点
		//在一个死循环里找到要插入的位置
		while (true) {
			preNode = currentNode;//首先让其保持一致,
			if (node.getNo() > currentNode.getNo()) {//此时应该向右查找插入的地方
				currentNode = currentNode.getLeft();
				if (currentNode == null) {//找到插入点。插入并返回
					preNode.setRight(node);
					return;
				}
			}else {
				currentNode = currentNode.getLeft();
				if (currentNode == null) {
					preNode.setLeft(node);
					return;
				}
			}
		}



	}

	//前序遍历
	public void preOrder(Node node) {
//		if(node == null) {//判断一棵树是否是空树
//			//System.out.println("当前节点为空！");
//			return;
//		}else {
//			//先打印“根”
//			System.out.println(node);
//
//			//在递归调用传进节点的左子树
//			preOrder(node.getLeft());
//
//			//再递归调用传进节点的右子树
//			preOrder(node.getRight());
//		}
		if (node != null) {//当前节点不为空
			//先打印“根”
			System.out.println(node);

			//在递归调用传进节点的左子树
			preOrder(node.getLeft());

			//再递归调用传进节点的右子树
			preOrder(node.getRight());

		}
		return;
	}

	//中序遍历
	public void infixOrder(Node node) {
		if(node != null) {
			infixOrder(node.getLeft());

			System.out.println(node);;

			infixOrder(node.getRight());

		}
		return;

	}

	//后序遍历
	public void postOrder(Node node) {
		if(node !=  null) {
			postOrder(node.getLeft());

			postOrder(node.getRight());

			System.out.println(node);
		}
		return;
	}

	//中序遍历查找(按照关键字)
	public Node SearchByKey(int key,Node node) {
		if(node == null) {
			return null;
		}
		if (key == node.getNo()){
			return node;
		}else if(key > node.getNo()) {
			return SearchByKey(key, node.getRight());
		}else {
			return SearchByKey(key, node.getLeft());
		}
	}
}

//创建节点
class Node{
	private int no;
	private String name;
	private Node left;
	private Node right;

	public Node() {
	}

	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}
}
