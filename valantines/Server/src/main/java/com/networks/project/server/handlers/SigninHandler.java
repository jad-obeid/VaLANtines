package com.networks.project.server.handlers;

import java.util.ArrayList;

import com.networks.project.server.database.User;
import com.networks.project.server.database.UserService;
import com.networks.project.server.responses.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SigninHandler {
    
    private static UserService service;

    @Autowired
    public SigninHandler(UserService service){
        this.service = service;
    }

    public static Response handleRequest(String request) {
        String[] credentials= request.split(";");
        String answer = verifyUser(credentials);
        ArrayList<String> s = new ArrayList<String>();
        s.add(answer);
        return new Response(5,s);
    }

    private static String verifyUser(String[] credentials){
        String username = credentials[0];
        String password = credentials[1];

        ArrayList<User> users = (ArrayList<User>) service.list();
        System.out.println(users);
        if(users!=null){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPasswod().equals(password))
                return "success";
        }
    }
        return "fail";
    }

}
