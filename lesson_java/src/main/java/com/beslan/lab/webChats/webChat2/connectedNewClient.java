package com.beslan.lab.webChats.webChat2;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class connectedNewClient {
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String nickName; // имя клиента

    // для создания необходимо принять адрес и номер порта
    public connectedNewClient(String addr, int port) {
        // ip адрес клиента
        // порт соединения
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            assert socket != null;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname(); // перед началом необходимо спросит имя
            new ReadMsg().start(); // нить читающая сообщения из сокета в бесконечном цикле
            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой
            // ошибке, кроме ошибки конструктора сокета:
            connectedNewClient.this.downService();
        }
        // В противном случае сокет будет закрыт
        // в методе run() нити.
    }

    private void pressNickname() {
        System.out.print("Введите имя : ");
        try {
            nickName = inputUser.readLine();
            out.write("Здравствуйте, " + nickName + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

    // нить чтения сообщений с сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine(); // ждем сообщения с сервера
                    if (str.equals("quit")) {
                        connectedNewClient.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    }
                    System.out.println(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
                connectedNewClient.this.downService();
            }
        }
    }

    // нить отправляющая сообщения приходящие с консоли на сервер
    public class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String msg;
                try {
                    Date time = new Date(); // текущая дата
                    SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
                    String dtime = dt1.format(time); // время
                    msg = inputUser.readLine(); // сообщения с консоли
                    if (msg.equals("quit")) {
                        out.write("quit" + "\n");
                        connectedNewClient.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    } else {
                        out.write("(" + dtime + ") " + nickName + ": " + msg + "\n"); // отправляем на сервер
                    }
                    out.flush(); // чистим
                } catch (IOException e) {
                    connectedNewClient.this.downService(); // в случае исключения тоже харакири
                }
            }
        }
    }
}
