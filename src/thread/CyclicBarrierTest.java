package thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public void exec() {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(new CBRunner(barrier, "1号"));
        pool.execute(new CBRunner(barrier, "2号"));
        pool.execute(new CBRunner(barrier, "3号"));
        pool.shutdown();
    }

    private class CBRunner implements Runnable{

        CyclicBarrier barrier;
        String name;

        CBRunner(CyclicBarrier barrier, String s) {
            super();
            this.barrier = barrier;
            this.name = s;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*(new Random().nextInt(10)));
                System.out.println("准备好了");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "起跑!");
        }
    }
}
