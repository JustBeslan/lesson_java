package com.beslan.lab.webChats.webChat1;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Start writing message...");
        try {
//            Socket s = new Socket("localhost",8000);
            Socket s = new Socket("192.168.43.141", 8000);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin = "", msgout = "";
            while (!msgout.equals("end")) {
                System.out.print("Your message : ");
                msgout = br.readLine(); // read client msg
                dout.writeUTF(msgout);

                msgin = din.readUTF();
                System.out.println(msgin); // print server msg
            }
        } catch (Exception e) {
        }
    }
}
