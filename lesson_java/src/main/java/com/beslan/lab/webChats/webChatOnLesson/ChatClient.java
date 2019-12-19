package com.beslan.lab.webChats.webChatOnLesson;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 9000));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        while (true) {
            writer.write(reader.readLine() + "/r/n");
        }
    }
}
