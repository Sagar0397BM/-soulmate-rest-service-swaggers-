package com.stackroute.soulMateDemo.DataSeeder;

import com.stackroute.soulMateDemo.Domain.User;
import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;
import com.stackroute.soulMateDemo.SoulMateDemoApplication;
import com.stackroute.soulMateDemo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.stackroute.soulMateDemo")
@Component
public class DataSeed implements CommandLineRunner{

    @Autowired
    private UserService userService;

    public DataSeed(UserService userService) {
        this.userService =userService;
    }



    @Override
    public void run(String... args) throws Exception {
        userService.saveUser(new User(1, "Henry", "Male", 25));
    }


}
