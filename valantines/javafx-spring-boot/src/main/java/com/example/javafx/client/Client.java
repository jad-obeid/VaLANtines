package com.example.javafx.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String ip = "localhost";
    private int port = 12345;

    public static Client client;
    private Client() {
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Client getClient(){  
        if (client == null){  
            client = new Client();//instance will be created at request time                
         }  
       return client;  
      }
    public String getIp(){
        return this.ip;
    }

    public int getPort(){
        return this.port;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    public void setPort(int port){
        this.port = port;
    }
    private void send(Request request) throws IOException {
        out.println(request.toString());
        out.flush();
    }

    private String receive() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendAndReceive(Request request) throws IOException {
        send(request);
        return receive();
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}