package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWrapper {
    private Socket socket;
    private Server server;
    private DataOutputStream out;
    private DataInputStream in;
    public ClientWrapper(Server server,Socket socket){
        try {
            this.server = server;
            this.socket= socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        readMessage();
                    }catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeConnection() {
        server.broadcastMsg(socket.getInetAddress() + ": вышел из чата");
        server.unsubscribe(this);
        try {
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void readMessage() throws IOException{
        while(true){
            String clientMessage = in.readUTF();
            if(clientMessage.equals("/end")){
                break;
            }
            server.broadcastMsg(socket.getInetAddress()+ ": " + clientMessage);
        }
    }
    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
