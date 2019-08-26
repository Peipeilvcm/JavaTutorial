package test;

import math.JosephusProblem;

/**
 * Created by Administrator on 2018/11/21.
 */
public class Test {
    public static void exec(){
//        char c = 256;
//        byte d = (byte)c;
//        Integer i = 1;
//        int i1 = new Integer(10);
//        long[] l = new long[10];
//        String a = "中abc国";
//        byte[] buf = a.getBytes();
//        System.out.println(a.length());
//        System.out.println(d);
//        System.out.println(buf.length);
//        System.out.println((-14)%3);
//        System.out.println(i1);
        System.out.println("n = 20110926, JosephusProblem");
        System.out.println("m = 7, res = " + JosephusProblem.slove1(20110926, 7));
        System.out.println("m = 11, res = " + JosephusProblem.slove1(20110926, 11));
        System.out.println("m = 17, res = " + JosephusProblem.slove1(20110926, 17));
        System.out.println("m = 37, res = " + JosephusProblem.slove1(20110926, 37));

        /*Queue<Integer> pq = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });*/
    }
}
