/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapi.main;

/**
 *
 * @author ronistone
 */
import com.restapi.controllers.CursoResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.restapi.controllers")
public class Main {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Main.class, args);
    }
}
