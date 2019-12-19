package com.beslan.lab.webChats.webChat2;

public class Client {
    public static String host = "192.168.43.141";
    //    public static String host = "localhost";
    public static int port = 8000;

    //создание клиент-соединения с узананными адресом и номером порта
    public static void main(String[] args) {
        new connectedNewClient(host, port);
    }
}

