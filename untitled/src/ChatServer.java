package org.example.project43;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            System.out.println("Сервер включился");
            System.out.println("Ожидаю...");

            // ждем клиента
            Socket socket = server.accept();
            System.out.println("Клиент подключился!");
            Client client = new Client(socket);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}
