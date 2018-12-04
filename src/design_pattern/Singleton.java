package design_pattern;

/**
 * Created by Administrator on 2018/11/20.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

// 饿汉
class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

// 双重检验锁
class Singleton3 {
    // volatile禁止指令重序优化
    private volatile static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    // 非原子操作
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

// 静态内部类
class Singleton4 {
    private static class Nest {
        private static final Singleton4 instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstance() {
        return Nest.instance;
    }
}

// 枚举
enum Singleton5{
    INSTANCE;

    // 静态方法, Singleton5.getValue()调用
    static int value;
    public static int getValue(){
        return value;
    }
    // 实例方法, Singleton5.INSTANCE.getType()调用
    String type;
    public String getType(){
        return type;
    }
}

