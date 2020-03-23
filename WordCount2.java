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
			System.out.println("�������Ĳ���,��һ��������ļ�·��");
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
				System.out.println("����������.");
			}
		}
	}

	// ͳ������
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
			System.out.println("�ļ�" + src.getName() + "������Ϊ�� " + linenum);
			System.out.println();
		} else {
			System.out.println(src.getName() + " �ļ������ڣ�");
		}
	}

	// ͳ���ַ���
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
			System.out.println("�ļ�" + src.getName() + "���ַ���Ϊ�� " + charnum);
			System.out.println();
		} else {
			System.out.println(src.getPath() + " �ļ������ڣ�");
		}
	}

	// ͳ�ƴ���
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
			System.out.println("�ļ�" + src.getName() + "�Ĵ�����Ϊ�� " + wordnum);
			System.out.println();
		} else {
			System.out.println(src.getName() + " �ļ������ڣ�");

		}
	}
}
