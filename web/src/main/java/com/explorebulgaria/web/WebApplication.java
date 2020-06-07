package com.explorebulgaria.web;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.models.Region;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Region.class)
                .addAnnotatedClass(Landmark.class)
                .buildSessionFactory();
    }

}
