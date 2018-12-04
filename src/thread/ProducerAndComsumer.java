package thread;

// wait-notify实现生产者消费者
public class ProducerAndComsumer {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void exec(){
        ProducerAndComsumer pAndC = new ProducerAndComsumer();
        new Thread(pAndC.new Producer()).start();
        new Thread(pAndC.new Producer()).start();
        new Thread(pAndC.new Producer()).start();
        new Thread(pAndC.new Comsumer()).start();
        new Thread(pAndC.new Comsumer()).start();
    }

    class Producer implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == FULL){
                        try {
                            LOCK.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Comsumer implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == 0){
                        try {
                            LOCK.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
