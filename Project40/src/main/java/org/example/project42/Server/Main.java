package org.example.project42.NetClient.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Ожидаю...");

        //ждем клиента
        Socket s = server.accept();
        System.out.println("Клиент подключился!");

        //получаем потоки ввода вывода
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        //Создаем удобные средства ввода вывода
        Scanner in = new Scanner(is);
        PrintStream out = new PrintStream(os);

        out.println("Как тебя зовут?");
        out.println("Привет, " + in.nextLine());
    }
}
