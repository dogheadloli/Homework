package wc;


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
        bw.write(num.toString());
        br.close();
        bw.close();
        return num;
    }
}
