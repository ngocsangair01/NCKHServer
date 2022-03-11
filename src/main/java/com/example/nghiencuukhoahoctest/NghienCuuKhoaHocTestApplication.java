package com.example.nghiencuukhoahoctest;

import com.cloudinary.Cloudinary;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NghienCuuKhoaHocTestApplication {

    @Bean
    public Slugify slugify() {
        return new Slugify();
    }
    public static void main(String[] args) {
        SpringApplication.run(NghienCuuKhoaHocTestApplication.class, args);
    }

}
