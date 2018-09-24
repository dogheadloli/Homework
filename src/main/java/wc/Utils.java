package wc;


import org.junit.Test;

import java.io.*;

/**
 * 2 * @Author: 睿
 * 3 * @Date: 2018/9/21 0021 17:51
 * 4
 */
public class Utils {
    public static int charNum(String fileName) throws IOException {
        Integer num = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw=new BufferedWriter(new FileWriter("result.txt"));
        int c;
        //统计字符数
        while((c=br.read())!=-1){
            if((char)c!='\r'&&(char)c!='\n'){
                num++;
            }
        }
        //写出结果
        bw.write(fileName+","+"字符数"+":");
        bw.write(num.toString());
        //关流
        br.close();
        bw.close();
        return num;
    }

    public static int wordNum(String fileName)throws IOException{
        Integer num=0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw=new BufferedWriter(new FileWriter("result.txt"));
        String currentLine=null;
        //储存分割后的数组
        String[] words=null;

        while((currentLine=br.readLine())!=null){
            currentLine=currentLine.replaceAll("[^_a-zA-Z]"," ");
            words=currentLine.split(" ");
            for(String word:words){
                //去掉空格，和空字符
                if(!word.equals(" ")&&!word.equals("")){
                    num++;
                }
            }
        }
        bw.write(fileName+","+"单词数"+":");
        bw.write(num.toString());
        br.close();
        bw.close();
        return num;
    }

    public static int lineNum(String fileName)throws IOException{
        Integer num=0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw=new BufferedWriter(new FileWriter("result.txt"));

        while((br.readLine())!=null){
            num++;
        }
        bw.write(fileName+","+"行数"+":");
        bw.write(num.toString());
        br.close();
        bw.close();
        return num;
    }

    @Test
    public int markLineNum(String fileName) throws IOException {
        Integer num = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("\r\n", "");
            if (isMark(line)) {
                num++;
            }
        }
        bw.write(fileName + "," + "空行、代码行、注释行数量" + ":");
        bw.write(num.toString());
        br.close();
        bw.close();
        return num;
    }

        private static boolean isMark(String line) {
        //判断是否为空行
        if (line == null || line .equals("")) {
            return true;
        }
        //判断是否以”*/“开头
        if (line.endsWith("*/")) {
            return true;
        }
        //判断是否以”//“开头
        if (line.startsWith("//")) {
            return true;
        }
        //判断是否以”/*“结尾
        if (line.startsWith("/*")) {
            return true;
        }
        return false;
    }
}
