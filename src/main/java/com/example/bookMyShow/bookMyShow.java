package com.example.bookMyShow;

import com.example.bookMyShow.controllers.UserController;
import com.example.bookMyShow.dtos.SignUpRequestDTO;
import com.example.bookMyShow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class bookMyShow implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
        signUpRequestDTO.setEmail("sonamgupta12256@gmail.com");
        signUpRequestDTO.setPassword("password");
        SignUpResponseDTO response =  userController.signUp(signUpRequestDTO);
    }

    public static void main(String[] args) {

        SpringApplication.run(bookMyShow.class, args);
    }

}
