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



## ArrayList<T> al t
al.add(t)
al.add(index, t)
al.get(index)



## Vector
同步,线程安全

## LinkedList<T> t ll
底层双向链表实现


## Stack<T> stk t
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
TreeMap
HashMap
Hashtable

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

## 数据转换
String s = String.valueOf(t);
int i = Integer.parseInt(s);



