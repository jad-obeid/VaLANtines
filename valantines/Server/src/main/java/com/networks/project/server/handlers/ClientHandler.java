package com.networks.project.server.handlers;
import java.io.*;
import java.net.Socket;
import com.networks.project.server.responses.Response;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Response response = handleRequest(line);
                bufferedWriter.write(response.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Response handleRequest(String request){
        int requestType = request.charAt(0)-'0';
        request = request.substring(request.indexOf(";")+1);
        switch (requestType){
            case 1:
                return ImageHandler.handleRequest(request);
            case 2:
                return MovieRecommendationApiHandler.handleRequest(request);
            case 3:
                return CompatibilityHandler.handleRequest(request);
        }
        return null;
    }

}