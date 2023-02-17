package com.example.springsercutiy;

import com.example.springsercutiy.Entity.Role;
import com.example.springsercutiy.Entity.User;
import com.example.springsercutiy.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@EnableWebSecurity
@EnableJpaRepositories
@SpringBootApplication
public class SpringSercutiyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSercutiyApplication.class, args);
    }
     @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
}

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_MANAGER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//
//            userService.saveUser(new User(null,"Long Nguyen","LongKane","longgiang@gmail.com","123456",new HashSet<>()));
//            userService.saveUser(new User(null,"Long Thanh","LongSaker","logi@gmail.com","123456",new HashSet<>()));
//
//            userService.addToUser("longgiang@gmail.com","ROLE_USER");
//            userService.addToUser("logi@gmail.com","ROLE_MANAGER");
//
//        };
//    }
}
