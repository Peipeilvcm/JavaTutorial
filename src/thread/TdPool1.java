package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TdPool1 {


    public void exec() throws IOException {
        // 创建线程池
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        // 设置线程数量满时的策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connect = socket.accept();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connect);
                }
            };
            pool.execute(r);
        }
    }

    private void handleRequest(Socket s){

    }
}
