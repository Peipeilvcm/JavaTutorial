package io;

import java.io.*;

/**
 * Created by Administrator on 2018/11/20.
 */
public class ByteStream {
    public static void exec() throws Exception{
        String str = "中国裴子祥";

        FileOutputStream fos = new FileOutputStream("bytestream_fos.txt");
        fos.write(str.getBytes("UTF-8"));
        fos.close();

        FileWriter fw = new FileWriter("bytestream_fw.txt");
        fw.write(str);
        fw.close();

        PrintWriter pw = new PrintWriter("bytestream_pw.txt","utf-8");
        pw.write(str);
        pw.close();

        FileInputStream fis = new FileInputStream("bytestream_fos.txt");
        byte[] buf_fis = new byte[1024];
        int len_fis = fis.read(buf_fis);
        String myStr = new String(buf_fis, 0, len_fis, "UTF-8");
        fis.close();
        System.out.println("FileInputStream: "+myStr);

        FileReader fr = new FileReader("bytestream_fw.txt");
        char[] buf_fr = new char[1024];
        int len_fr = fr.read(buf_fr);
        myStr = new String(buf_fr, 0, len_fr);
        fr.close();
        System.out.println("FileReader: "+myStr);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("bytestream_fos.txt"),"UTF-8"
                )
        );
        myStr = br.readLine();
        br.close();
        System.out.println("BufferedRead: "+myStr);
    }
}
