package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] items = new Object[100]; // 缓存队列

    int putptr; // 写索引
    int takeptr; // 读索引
    int count = 0;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try{
            while (count == items.length){
                notFull.await();
            }
            items[putptr] = x;
            if(++putptr == items.length){
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try{
            while (count == 0){
                notEmpty.await();
            }
            Object x = items[takeptr];
            items[takeptr] = null;
            if(++takeptr == items.length){
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}
