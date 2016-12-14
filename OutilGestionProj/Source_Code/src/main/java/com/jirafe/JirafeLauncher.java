package com.jirafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.jirafe"})
public class JirafeLauncher {

    public static void main(String[] args) {
        SpringApplication.run(JirafeLauncher.class, args);
    }
    
}
