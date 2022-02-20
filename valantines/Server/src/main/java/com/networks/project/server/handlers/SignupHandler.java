package com.networks.project.server.handlers;

import java.util.ArrayList;

import com.networks.project.server.database.User;
import com.networks.project.server.database.UserService;
import com.networks.project.server.responses.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupHandler {
    
    private static UserService service;

    @Autowired
    public SignupHandler(UserService service){
        this.service = service;
    }
    public static Response handleRequest(String request) {
        String[] credentials= request.split(";");
        String answer = addUser(credentials);
        ArrayList<String> s = new ArrayList<String>();
        s.add(answer);
        return new Response(4,s);
    }

    private static String addUser(String[] credentials) {
        String username = credentials[0];
        String email = credentials[1];
        String password = credentials[2];
        System.out.println(username+" "+email+" "+password);
        User user = new User(username,email,password);
        String result = service.addNewUser(user);
        return result;
    }

}
