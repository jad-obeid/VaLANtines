package com.networks.project.server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.networks.project.server.handlers.ClientHandler;

public class Server {

    private ServerSocket serverSocket;
    private final int port;

    public Server(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {

        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}