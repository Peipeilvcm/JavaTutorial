精简utils java用法

## String s
s.length()
s.substring(0,n) 是 s[0..n-1]
String[] strs = s.split(" |\\.|\\||abc") |为连字符,\\为转义字符
char c = s.charAt(index);
char[] c_s = s.toCharArray();
s = String.valueOf(c_s)
int index = s.indexOf(int ch);// 未找到返回-1 lastIndexOf


## StringBuilder
StringBuilder sb = new StringBuilder();
sb.append(s);
sb.toString();


## Array: a
T[] a = new T[10];

a.length
Arrays.sort(a) //增序排序
Arrays.sort(a, Collections.reverseOrder()); // 逆序
Arrays.sort(a, 2, 6) 对部分a[2..5]排序
class TComp implements Comparator<T>{
    @Override
    public int compare(T t1, T t2){
        return t1.val - t2.val;
    }
}
Arrays.sort(a, new TComp());


##
### Collection: Set、List、Queue
Set : HashSet、LinkedHashSet、TreeSet : SortedMap
List : ArrayList、Vector、LinkedList
Queue : LinkedList、PriorityQueue
### Map: Hashtable、 LinkedHashMap、 HashMap、 TreeMap : SortedMap
### Collections集合方法，各种操作

## ArrayList<T> al t
al.add(t)
al.add(index, t)
al.get(index)



## Vector
同步,线程安全，方法添加synchronized关键字
扩容 2倍，ArrayList 扩容1.5倍

## LinkedList<T> t ll
底层双向链表实现


## Stack<T> stk t
继承Vector
Stack<T> stack = new Stack<T>();
stk.push(t);
t = stk.peek();
t = stk.pop();

## Queue<T> t que
Queue<T> que = new LinkedList<T>()
que.offer(t)   // 插入 , 不推荐add()、remove()、que.element()失败时会抛出异常
t = que.poll() // 返回第一个元素并删除
t = que.peek()

// 优先队列
Queue<T> minHeap = new PriorityQueue<T>(); // 默认最小堆
Queue<T> maxHeap = new PriorityQueue<T>(10,
                        new Comparator<T>(){
                            public int compare(T t1, T t2){
                                return t2.val - t1.val;
                            }
                        });
方法 offer、poll、peek


## Map
TreeMap : SortedMap 默认是按键值的升序排序（自然顺序），也可以指定排序的比较器，当用Iterator遍历TreeMap时，得到的记录是排过序的。不允许key值为空，非同步的。
Hashtable 是Directory的具体实现类, 它不允许记录的键或者值为null
HashMap 允许一个键为null,允许多个值为null
LinkedHashMap 保存了记录的插入顺序，在用Iteraor遍历LinkedHashMap时，先得到的记录肯定是先插入的
IdentityHashMap 用==来判断键是否相等，即比较引用是否相等
ConcurrentHashMap 线程安全，并且锁分离。ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分
每个段其实就是一个小的hashtable, 它们有自己的锁。只要多个修改操作发生在不同的段上，它们就可以并发进行。

Map的遍历
Iterator it = map.entrySet().iterator();
while(it.hasNext()){
    Entry e =(Entry) it.next();
    System.out.println("键"+e.getKey () + "的值为" + e.getValue());
}

## Set

HashSet
LinkedHashSet
TreeSet // 有序, 类似二叉排序树, 中序遍历从小到大, 插入CABEFD遍历ABCDEF
TreeSet<T> ts=new TreeSet<T>(new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o2.val - o1.val;
			}
		});
如果T 实现 Comparable接口，则重写compareTo

// 迭代器遍历
for(Iterator it = set.iterator(); it.hasNext();){
    Object o = it.next();
    if("实例".equals(o)){
        it.remove();
        it.set(o1); //可以修改值
    }
}


## Pair
Pair<T1, T2> pair = new Pair<>(t1, t2);
t1 = pair.getKey();
t2 = pair.getValue();



## regex
String str;
String pattern = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
boolean isMatch = Pattern.matched(pattern, str);


## Scanner
Scanner scan = new Scanner(System.in)
while(scan.hasNext()){
    String s = scan.next(); // 以空格或行为分割
}
while(scan.hasNextLine()){
    String s = scan.nextLine(); // 以行分割，可以获得空白
}
hasNextInt(),nextInt;hasNextXxx,nextXxx;

## Lock
lock()
boolean tryLock()
boolean tryLock(delay, )


## 数据转换
String s = String.valueOf(t);
int i = Integer.parseInt(s);


## 泛型
<T>
修饰方法，放在返回值之前。然后整个方法的任何地方都可以用 T
可以对 T 进行修饰， <T extends Comparable<T>>
修饰类 class Exam<T>{} 进行类定义，整个类都能用


## IO
字节流: InputStream、OutputStream
字符流: Reader、Writer
InputStream: FileInputStream、SocketInputStream, int len = inS.read(buf) != -1方法, outS.write(buf, 0, len)
可以用BufferedOutputStream包装 OutputStream out = new BufferedOutputStream(new ObejectOutputStream(new FileOutputStream(new File('filename'))));

## JVM 虚拟机
###



