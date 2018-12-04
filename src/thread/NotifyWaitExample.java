package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NotifyWaitExample {
    private volatile boolean go = false;

    public static void exec() throws InterruptedException{
        final NotifyWaitExample notifyWaitExample = new NotifyWaitExample();

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try{
                    notifyWaitExample.shouldGo();
                }catch (InterruptedException e){
                    Logger.getLogger(NotifyWaitExample.class.getName()).
                            log(Level.SEVERE, null, e);
                }
                System.out.println(Thread.currentThread() + " finished Execution");
            }
        };

        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                notifyWaitExample.go();
                System.out.println(Thread.currentThread() + " finished Execution");
            }
        };

        Thread t1 = new Thread(waitTask, "WT1"); //will wait
        Thread t2 = new Thread(waitTask, "WT2"); //will wait
        Thread t3 = new Thread(waitTask, "WT3"); //will wait
        Thread t4 = new Thread(notifyTask,"NT1"); //will notify

        //starting all waiting thread
        t1.start();
        t2.start();
        t3.start();

        //pause to ensure all waiting thread started successfully
        Thread.sleep(200);

        //starting notifying thread
        t4.start();
    }

    private synchronized void shouldGo() throws InterruptedException{
        while (go != true){
            System.out.println(Thread.currentThread()+" is going to wait");
            wait();
            System.out.println(Thread.currentThread()+" is woken up");
        }
        go = false;
    }

    private synchronized void go(){
        while (go == false){
            System.out.println(Thread.currentThread() + " is going to notify all or one");
            go = true;
            notify();
//            notifyAll();
        }
    }
}
