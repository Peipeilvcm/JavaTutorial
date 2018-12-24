package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketEx_NIO {
    public void selector() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024); //capacity, position, limit。buffer的操作都是改这几个值
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false); //非阻塞方式
        ssc.socket().bind(new InetSocketAddress(8080));
        ssc.register(selector, SelectionKey.OP_ACCEPT); // 注册事件
        while (true){
            selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    it.remove();
                }else if((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true){
                        buffer.clear();
                        int n = sc.read(buffer); // 往buffer里写，
                        if(n <= 0){
                            break;
                        }
                        buffer.flip(); // buffer变成读状态，和remind只差 limit = position来标识有效数据来读
                    }
                    it.remove();
                }
            }
        }
    }
}
