package thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void exec() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        // 等待并获取结果
        System.out.println(future.get());
    }

    void solve(Executor e, Collection<Callable<Integer>> solvers) throws InterruptedException, ExecutionException {
        CompletionService ecs = new ExecutorCompletionService(e);
        int n = solvers.size();
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>(n);

        try {
            for(Callable<Integer> c : solvers){
                // 每一次submit都启动了一个线程
                futures.add(ecs.submit(c));
            }
            Integer res = null;
            for(int i = 0; i < n; ++i){
                // 等待有一个返回结果，线程结束
                Integer r = (Integer) ecs.take().get();
                if(r != null) {
                    res = r;
                    break;
                }
            }
        }finally {
            for(Future<Integer> f : futures){
                // 将其它线程全部结束
                f.cancel(true);
            }
        }

    }
}
