package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketEx {
    // BIO
    public static void exec() throws IOException {
        ServerSocket server = new ServerSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 18824);
        server.bind(address);
        Socket socket = server.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader((
                    socket.getInputStream())));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader keyword = new BufferedReader(new InputStreamReader((
                    System.in)));

        while (true) {
            if(reader.ready()){
                String info = reader.readLine();
                System.out.println("Client" + info);
            }
            if(keyword.ready()){
                String test = keyword.readLine();
                writer.println(test);
                System.out.println("Server" + test);
            }
        }

    }
}
