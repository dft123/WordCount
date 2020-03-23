package dft.wc.cn;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCount2 {
	
	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
		String str =null;
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("输入您的操作,空一格后输入文件路径");
			 str = scanner.nextLine();
			String[] strArr = str.split(" ");
			switch (strArr[0]) {
			case "-c":
				charcount(strArr[1]);
				break;
			case "-w":
				wordcount(strArr[1]);
				break;
			case "-l":
				linecount(strArr[1]);
				break;
			default:
				System.out.println("操作不存在.");
			}
		}
	}

	// 统计行数
	public static void linecount(String path) throws IOException {
		File src = new File(path);
		int linenum = 0;
		if (src.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(src));
			while (true) {

				if (br.readLine() == null)
					break;
				else
					linenum++;
			}
			br.close();
			System.out.println("文件" + src.getName() + "的行数为： " + linenum);
			System.out.println();
		} else {
			System.out.println(src.getName() + " 文件不存在！");
		}
	}

	// 统计字符数
	public static void charcount(String path) throws IOException {
		File src = new File(path);
		int charnum = 0;
		int a = 0;
		if (src.exists()) {
			BufferedReader br2 = new BufferedReader(new FileReader(src));
			while (a != -1) {
				a = br2.read();
				if (a >= 33 && a <= 126)
					charnum++;
				else
					continue;
			}
			br2.close();
			System.out.println("文件" + src.getName() + "的字符数为： " + charnum);
			System.out.println();
		} else {
			System.out.println(src.getPath() + " 文件不存在！");
		}
	}

	// 统计词数
	public static void wordcount(String path) throws IOException {
		File src = new File(path);
		int wordnum = 0;
		int a = 0, flag = 0;
		if (src.exists()) {
			BufferedReader br2 = new BufferedReader(new FileReader(src));
			while (a != -1) {
				a = br2.read();
				if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
					if (flag == 0)
						flag = 1;
				} else {
					if (flag == 1) {
						wordnum++;
						flag = 0;
					} else
						continue;
				}
			}
			br2.close();
			System.out.println("文件" + src.getName() + "的词数数为： " + wordnum);
			System.out.println();
		} else {
			System.out.println(src.getName() + " 文件不存在！");

		}
	}
}
