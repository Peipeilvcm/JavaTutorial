package thread;

/**
 * Created by Administrator on 2018/11/20.
 * 子线程循环 10 次，接着主线程循环 100，接着又回到子线程循环 10 次，
 * 接着再回到主线程又循环 100，如此循环 5 次，
 */
public class TdExample2 {
    private int j;
    boolean subFlag;

    public TdExample2(){
        j = 0;
        subFlag = true;
    }

    public static void exec(){
        TdExample2 example2 = new TdExample2();
        SubRunnable sub = example2.new SubRunnable();

        new Thread(sub).start();

        for(int i = 0; i < 5; ++i){
            example2.mainAct();
        }
    }

    private synchronized void subAct(){
        if(!subFlag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10; ++i){
            ++j;
            System.out.println(Thread.currentThread().getName() + " subAct, j = " + j);
        }
        subFlag = false;
        this.notify();
    }

    private synchronized void mainAct(){
        if(subFlag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 100; ++i){
            --j;
            System.out.println(Thread.currentThread().getName() + " mainAct, j = " + j);
        }

        subFlag = true;
        this.notify();
    }

    class SubRunnable implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 5; ++i){
                subAct();
            }
        }
    }

}
