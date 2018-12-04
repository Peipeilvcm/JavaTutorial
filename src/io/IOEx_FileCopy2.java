package io;

import java.io.*;

/**
 * Created by Administrator on 2018/11/21.
 * 将 d:\java 目录下的所有.java 文件复制到 d:\jad 目录下，并
 * 将原来文件的扩展名从.java 改为.jad
 */
public class IOEx_FileCopy2 {
    public static void exec() throws Exception{
        File srcDir = new File("java");
        if(!(srcDir.exists() && srcDir.isDirectory())){
            throw new Exception("目录不存在");
        }
        File[] files = srcDir.listFiles(
                new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".java");
                    }
                }
        );

        System.out.println(files.length);
        File destDir = new File("jad");
        if(!destDir.exists()){
            destDir.mkdir();
        }

        for(File f : files){
            FileInputStream fis = new FileInputStream(f);
            String destFileName = f.getName().replaceAll("\\.java$",".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
            copy(fis, fos);
            fis.close();
            fos.close();
        }
    }

    private static void copy(InputStream ips, OutputStream ops) throws Exception{
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = ips.read(buf)) != -1){
            ops.write(buf, 0, len);
        }
    }
}
