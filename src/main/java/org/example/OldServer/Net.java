package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Net {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Ожидаем подключение...");
            Socket client = serverSocket.accept();  //ожидает подключение от клиента
            System.out.println("Подключился клиент: " + client.getInetAddress());
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        String s = scanner.nextLine();
                        try {
                            out.writeUTF(s);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            while (true){
                String s = in.readUTF();
                if(s.equals("/end")){
                    in.close();
                    out.close();
                    client.close();
                    serverSocket.close();
                    break;
                }
                System.out.println("Клиент прислал: " + s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
