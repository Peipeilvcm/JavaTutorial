package thread;

/**
 * Created by Administrator on 2018/11/20.
 * 实现多线程方法2
 * 推荐使用Runnable接口开发多线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("MyRunnable");
    }
}
