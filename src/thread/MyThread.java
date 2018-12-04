package thread;

/**
 * Created by Administrator on 2018/11/20.
 * 实现多线程方法1
 * 继承Thread实现多线程
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        super.run();
        System.out.println("MyThread");
    }
}
