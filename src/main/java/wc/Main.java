package wc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static wc.Utils.charNum;
import static wc.Utils.lineNum;
import static wc.Utils.wordNum;

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
                    //判断是否为3个词
                    if (commands.length == 3) {
                        //判断第一个词是否为wc.exe
                        if ("wc.exe".equals(commands[0])) {
                            //判断第三个词是否以.c结尾
                            if (!commands[2].endsWith(".c")) {
                                System.out.println("必须以.c结尾");
                                continue;
                            }
                            //判断第二个词
                            switch (commands[1]) {
                                case "-c":
                                    System.out.println(charNum(commands[2]));
                                    break;
                                case "-w":
                                    System.out.println(wordNum(commands[2]));
                                    break;
                                case "-l":
                                    System.out.println(lineNum(commands[2]));
                                    break;
                                default:
                                    System.out.println("错误，请重新输入");
                                    break;
                            }
                        } else {
                            System.out.println("错误，请重新输入");
                            continue;
                        }
                    } else {
                        System.out.println("错误，请重新输入");
                        continue;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("文件不存在");
            } catch (IOException e) {
                System.out.println("读取文件失败");
            }
        }
    }
}
