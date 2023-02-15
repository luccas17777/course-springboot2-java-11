package com.ibm.course.config;

import com.ibm.course.entities.User;
import com.ibm.course.repositories.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //Para dizer para o spring que essa é uma classe de configuração
@Profile("test") // esse "teste" é o mesmo que esta no application test properties
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepositroy userRepositroy;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User();

        userRepositroy.saveAll(Arrays.asList(u1, u2));
    }
}
