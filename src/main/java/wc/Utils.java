package wc;


import java.io.*;

/**
 * 2 * @Author: 睿
 * 3 * @Date: 2018/9/21 0021 17:51
 * 4
 */
public class Utils {

	public static Integer charNum(String fileName) throws IOException {
		Integer num = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true));
		int c;
		// 统计字符数
		while ((c = br.read()) != -1) {
			if ((char) c != '\r' && (char) c != '\n') {
				num++;
			}
		}
		// 写出结果
		bw.write(fileName + "," + "字符数" + ":");
		bw.write(num.toString() + "\r\n");
		// 关流
		br.close();
		bw.close();
		return num;
	}

	public static Integer wordNum(String fileName) throws IOException {
		Integer num = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true));
		String currentLine = null;
		// 储存分割后的数组
		String[] words = null;

		while ((currentLine = br.readLine()) != null) {
			currentLine = currentLine.replaceAll("[^_a-zA-Z]", " ");
			words = currentLine.split(" ");
			for (String word : words) {
				// 去掉空格，和空字符
				if (!" ".equals(word) && !"".equals(word)) {
					num++;
				}
			}
		}
		// 写出结果
		bw.write(fileName + "," + "单词数" + ":");
		bw.write(num.toString() + "\r\n");
		// 关流
		br.close();
		bw.close();
		return num;
	}

	public static Integer lineNum(String fileName) throws IOException {
		Integer num = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true));

		while ((br.readLine()) != null) {
			num++;
		}
		// 写出结果
		bw.write(fileName + "," + "行数" + ":");
		bw.write(num.toString() + "\r\n");
		// 关流
		br.close();
		bw.close();
		return num;
	}

	public static Integer markLineNum(String fileName) throws IOException {
		Integer num = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true));
		String line = null;

		while ((line = br.readLine()) != null) {
			line = line.replaceAll("\\s|\r|\n", "");
			if (isMark(line)) {
				num++;
			}
		}
		// 写出结果
		bw.write(fileName + "," + "空行、注释行数量" + ":");
		bw.write(num.toString() + "\r\n");
		// 关流
		br.close();
		bw.close();
		return num;
	}

	public static String floder(String command, String floderName) throws IOException {
		File file = new File(floderName);
		if (file.exists()) {
			if (!file.isDirectory()) {
				// 如果是文件且以.c结尾，就调用相应函数
				if (file.getName().endsWith(".c")) {
					switch (command) {
						case "-c":
							charNum(file.getPath());
							break;
						case "-w":
							wordNum(file.getPath());
							break;
						case "-l":
							lineNum(file.getPath());
							break;
						case "-a":
							markLineNum(file.getPath());
							break;
						default:
							return "格式错误，请重新输入";
					}
				}
			} else {
				// 如果是文件夹，则递归调用
				File[] files = file.listFiles();
				for (File file1 : files) {
					floder(command, file1.getPath());
				}
			}
			return "ok";
		} else {
			return "文件夹不存在";
		}
	}

	private static boolean isMark(String line) {
		// 判断是否为空行
		if (line == null || "".equals(line)) {
			return true;
		}
		// 判断是否以”*/“开头
		if (line.endsWith("*/")) {
			return true;
		}
		// 判断是否以”//“开头
		if (line.startsWith("//")) {
			return true;
		}
		// 判断是否以”/*“结尾
		if (line.startsWith("/*")) {
			return true;
		}
		return false;
	}
}
