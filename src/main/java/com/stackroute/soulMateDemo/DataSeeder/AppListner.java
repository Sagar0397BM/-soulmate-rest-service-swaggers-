package com.stackroute.soulMateDemo.DataSeeder;

import com.stackroute.soulMateDemo.Domain.User;
import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;
import com.stackroute.soulMateDemo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.stackroute.soulMateDemo")
@Component
public class AppListner implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService;

    public AppListner(UserService userService) {
        this.userService =userService;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            userService.saveUser(new User(2, "Kiran", "Female", 25));
        } catch (UserAlradyExistsException e) {
            e.printStackTrace();
        }
    }
}
