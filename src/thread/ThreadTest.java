package thread;

/**
 * Created by Administrator on 2018/11/20.
 */
public class ThreadTest {
    public static void exec(){
//        MyThread mythread = new MyThread();
//        mythread.start();
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("over");
    }
}
