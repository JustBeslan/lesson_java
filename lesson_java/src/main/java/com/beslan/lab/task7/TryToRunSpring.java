package com.beslan.lab.task7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@SpringBootApplication
public class TryToRunSpring {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TryToRunSpring.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
    }

    @RequestMapping("/page1")
    public String home() {
        return ("Hello World!" + "Заработало!!! Я так рад!!! Понимаю, что рано, но все же");
    }
}
