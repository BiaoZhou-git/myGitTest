package com.sparsearray;

import java.io.*;
import java.util.SortedMap;

/**
 * @author tiko
 * @createDate 2019/12/16-11:48
 */
public class SparseArray {
	public static void main(String[] args) throws IOException {
		int[][] chessArray = new int[11][11];

		chessArray[1][2] = 1;
		chessArray[2][3] = 2;

		System.out.println("原始二维数组为:");
		for (int[] ints : chessArray) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}

		//将二维数组转化为稀疏数组
		//1.先遍历二维数组，得到非0的数组个数
		int num = 0;
		for (int[] ints : chessArray) {
			for (int anInt : ints) {
				if(anInt != 0) {
					num++;
				}
			}
		}

		//2.创建稀疏数组sparseArray
		int[][] sparseArray = new int[num + 1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = num;
		int count = 0;//对稀疏数组中是第几个非零元素
		for (int i = 0; i < chessArray.length; i++) {
			for (int i1 = 0; i1 < chessArray[i].length; i1++) {
				if(chessArray[i][i1] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = i1;
					sparseArray[count][2] = chessArray[i][i1];
				}
			}
		}

		System.out.println("转化为稀疏数组后:");
		for (int[] ints : sparseArray) {
			for (int i : ints) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}


//		FileOutputStream fos = new FileOutputStream("sparse.txt");
//		for (int i = 0; i < sparseArray.length; i++) {
//			for (int j = 0; j < sparseArray[i].length; j++) {
//				fos.write((char)sparseArray[i][j]);
//			}
//		}
//		fos.close();

		System.out.println("向文件中写入稀疏数组：");
//		FileWriter fw = new FileWriter("sparse.txt");
		BufferedWriter bfw = new BufferedWriter(new FileWriter("sparse.txt"));
		for (int i = 0; i < sparseArray.length; i++) {
			for (int j = 0; j < sparseArray[i].length; j++) {
				bfw.write(String.valueOf(sparseArray[i][j]) + " ");
			}
			bfw.newLine();
		}
		bfw.close();
		System.out.println("写入完毕...");

		System.out.println();
		System.out.println("从文件中读取稀疏数组:");
//		FileReader fr = new FileReader("sparse.txt");
		BufferedReader bfr = new BufferedReader(new FileReader("sparse.txt"));
		String line = null;

		String[] str = bfr.readLine().split(" ");
		int newr = Integer.parseInt(str[0]);
		int newc = Integer.parseInt(str[1]);
		int[][] newChessArray = new int[newr][newc];

		while((line = bfr.readLine())!= null){
			String[] s = line.split(" ");
			newChessArray[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
		}
		bfr.close();

		System.out.println("从文件中还原出来的二维数组为:");
		for (int[] ints : newChessArray) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}

		//3.从稀疏数组中恢复为原来的二维数组
		int row = sparseArray[0][0];
		int col = sparseArray[0][0];
		int[][] originArray = new int[row][col];
		for (int i = 1; i < sparseArray.length; i++) {
			int r = sparseArray[i][0];
			int c = sparseArray[i][1];
			originArray[r][c] = sparseArray[i][2];
		}

		System.out.println("还原后的二维数组为:");
		for (int[] ints : chessArray) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}


	}
}
