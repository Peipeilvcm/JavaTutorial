package io;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 * 输入为一个字符串和字节数，输出为按字节截取的字符串，但要保证汉字不被截取半个
 * “我ABC汉DEF”， 6，应该输出“我ABC”+“汉DEF”
 */
public class IOEx_Code3 {
    public static void exec(){
        String str = "我爱a中华abc我啊调查23";
//        String str = "欧123耕撒";
        int[] a = new int[0];
        try {
            a = trimGBK(str.getBytes("GBK"), 6);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int index  = 0;
        System.out.println(Arrays.toString(a));
        for(int num : a){
            System.out.println(str.substring(index, num));
            index = num;
        }
        if(index != str.length()){
            System.out.println(str.substring(index));
        }
    }
    public static int[] trimGBK(byte[] buf, int n){
        List<Integer> list = new ArrayList<Integer>();
        int num = 0;
        int cnt = 0;
        boolean isChineseHalf = false;
        int i;
        for(i = 0; i < buf.length-1; ++i){
            ++cnt;
            if(buf[i] < 0 && !isChineseHalf){
                isChineseHalf = true;
            }else{
                ++num;
                isChineseHalf = false;
            }
            if(cnt == n){
                list.add(num);
                if(isChineseHalf){
                    cnt = 1;
                }else {
                    cnt = 0;
                }
            }
        }

        int[] a = new int[list.size()];
        for(i = 0; i < a.length; ++i){
            a[i] = list.get(i);
        }

        return a;
    }

}
