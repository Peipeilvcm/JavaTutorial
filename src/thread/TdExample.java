package thread;

/**
 * Created by Administrator on 2018/11/20.
 * 设计4个线程，两个每次对j加1，两个每次对j减1
 *
 * 当一个A线程进入对象的一个synchronized方法，其它线程不可进入此对象其它synchronized方法
 * 除非A线程内部调用wait
 * 其它线程可以进入普通方法，不能进入带同步的static方法
 */
public class TdExample {
    private int j;
    public static void exec(){
        TdExample example = new TdExample();
        AddRunnable add = example.new AddRunnable();
        DecRunnable dec = example.new DecRunnable();

        for(int i = 0; i < 2; ++i){
            Thread t = new Thread(add);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    private synchronized void add(){
        ++j;
        System.out.println(Thread.currentThread().getName() + " add to " + j);
    }
    private synchronized void dec(){
        --j;
        System.out.println(Thread.currentThread().getName() + " dec to " + j);
    }

    class AddRunnable implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 100; ++i){
                add();
            }
        }
    }

    class DecRunnable implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 100; ++i){
                dec();
            }
        }
    }
}
