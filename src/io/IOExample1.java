package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Administrator on 2018/11/20.
 * 将 a.txt 文件中的单词与 b.txt 文件中的单词交替合并到 c.txt
 * 文件中， a.txt 文件中的单词用回车符分隔， b.txt 文件中用回车或空格进行分隔
 */
public class IOExample1 {
    public static void exec() throws Exception{
        FileManager a = new FileManager("a.txt", new char[]{'\n'});
        FileManager b = new FileManager("b.txt", new char[]{'\n',' '});
        FileWriter c = new FileWriter("c.txt");
        String aWord = null;
        String bWord = null;
        while((aWord = a.nextWord()) != null){
            c.write(aWord + "\n");
            bWord = b.nextWord();
            if(bWord != null){
                c.write(bWord + "\n");
            }
        }
    }
}

class FileManager{
    String[] words = null;
    int pos = 0;
    public FileManager(String filename, char[] seperators) throws Exception{
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        char[] buf = new char[(int)f.length()];
        int len = fr.read(buf);
        String res = new String(buf, 0, len);
        String regex = null;
        if(seperators.length == 0){
            regex = " ";
        }else{
            regex = "" + seperators[0];
            for(int i = 1; i < seperators.length - 1; ++i){
                regex = regex + "|" + seperators[i];
            }
        }
        words = res.split(regex);
    }

    public String nextWord(){
        if(pos == words.length){
            return null;
        }
        return words[pos++];
    }
}
