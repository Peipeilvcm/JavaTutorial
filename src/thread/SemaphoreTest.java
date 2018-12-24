package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void exec() {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);
        for(int i = 0; i < 20; ++i) {
            int finalI = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire(); // 获取一个许可，不成功阻塞
                        System.out.println("Accessing" + finalI);
                        Thread.sleep((long) (Math.random())*1000);
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            pool.execute(run);
        }
        pool.shutdown(); // 关闭线程池
    }
}
