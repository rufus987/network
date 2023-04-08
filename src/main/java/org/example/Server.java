package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final int PORT = 8189;
    private List<ClientWrapper> clients;
    public Server(){
        clients = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while(true) {
                System.out.println("Ожидаем подключение...");
                Socket client = serverSocket.accept();
                System.out.println("Подключился клиент: " + client.getInetAddress());
                clients.add(new ClientWrapper(this, client));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public synchronized void broadcastMsg(String msg) {
        for (ClientWrapper client : clients) {
            client.sendMsg(msg);
        }
    }
    public synchronized void unsubscribe(ClientWrapper clientWrapper){
        clients.remove(clientWrapper);
    }
}
