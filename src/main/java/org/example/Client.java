package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = in.readUTF();
                            System.out.println(s);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                out.writeUTF(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
