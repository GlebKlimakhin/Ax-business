package com.axioma.axiomabusiness;

import com.axioma.axiomabusiness.model.entity.Group;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AxiomaBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxiomaBusinessApplication.class, args);
        Group group = new Group();
    }

}
