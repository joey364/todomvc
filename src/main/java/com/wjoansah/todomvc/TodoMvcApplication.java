package com.wjoansah.todomvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TodoMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
       return args -> {
         var todos = List.of(
             new TodoItem("Trash", "take out the trash", false),
             new TodoItem("Family", "touch grass", false),
             new TodoItem("Health", "take a walk", true)
         );
         repository.saveAll(todos);
       } ;
    }
}
