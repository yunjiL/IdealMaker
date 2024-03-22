package com.ideal.idealmaker.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ideal.idealmaker.gallery")

public class GalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryApplication.class, args);
    }
}
