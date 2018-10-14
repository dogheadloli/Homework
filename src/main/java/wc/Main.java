package wc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static wc.Utils.*;

/**
 * 2 * @Author: 睿
 * 3 * @Date: 2018/9/21 0021 17:51
 * 4    作业
 */
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String currentCommand = null;
		String[] commands = null;
		while (true) {
			try {
				//判断命令是否为空
				if ((currentCommand = br.readLine()) != null) {
					commands = currentCommand.split(" ");
					//判断是否为3个词或四个词
					if (commands.length == 3 || commands.length == 4) {
						//判断第一个词是否为wc.exe
						if ("wc.exe".equals(commands[0])) {
							switch (commands[1]) { //判断第二个词
								case "-c":
									System.out.println(charNum(commands[2]));
									break;
								case "-w":
									System.out.println(wordNum(commands[2]));
									break;
								case "-l":
									System.out.println(lineNum(commands[2]));
									break;
								case "-a":
									System.out.println(markLineNum(commands[2]));
									break;
								case "-s":
									System.out.println(floder(commands[3],commands[2]));
									break;
								default:
									System.out.println("格式错误，请重新输入");
									break;
							}
						} else {
							System.out.println("格式错误，请重新输入");
							break;
						}
					} else {
						System.out.println("格式错误，请重新输入");
						break;
					}
				} else {
					System.out.println("错误，命令不能为空");
					break;
				}
			} catch (FileNotFoundException e) {
				System.out.println("找不到文件");
			} catch (IOException e) {
				System.out.println("打开文件失败");
			}
		}
	}
}
