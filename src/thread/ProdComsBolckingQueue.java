package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

// BlockingQueue实现生产者消费者
public class ProdComsBolckingQueue {
    private static Integer count = 10;
    final BlockingDeque<Integer> blockingDeque = (BlockingDeque<Integer>) new ArrayBlockingQueue<Integer>(10);

    class Producer implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    // 当队列满时阻塞 offer 是返回特定制 add是抛异常
                    blockingDeque.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Comsumer implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                try {
                    blockingDeque.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
