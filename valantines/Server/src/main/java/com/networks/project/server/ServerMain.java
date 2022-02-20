package com.networks.project.server;
import com.networks.project.server.server.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ServerMain {
    public static void main(String[] args){
        SpringApplication.run(ServerMain.class, args);
        Server server = new Server(12345);
        server.start();
    }
}
