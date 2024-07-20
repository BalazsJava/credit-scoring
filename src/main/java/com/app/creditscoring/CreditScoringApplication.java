package com.app.creditscoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditScoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditScoringApplication.class, args);

        System.out.println("""
                  _____           ___ __     ____             _              ______           __         __
                 / ___/______ ___/ (_) /_   / __/______  ____(_)__  ___ _   / __/ /____ _____/ /____ ___/ /
                / /__/ __/ -_) _  / / __/  _\\ \\/ __/ _ \\/ __/ / _ \\/ _ `/  _\\ \\/ __/ _ `/ __/ __/ -_) _  /\s
                \\___/_/  \\__/\\_,_/_/\\__/  /___/\\__/\\___/_/ /_/_//_/\\_, /  /___/\\__/\\_,_/_/  \\__/\\__/\\_,_/ \s
                                                                  /___/                                   \s
                """);
        System.out.println("""
                  _      __    __                     _   __         _\s
                 | | /| / /__ / /______  __ _  ___   | | / /__ ___  (_)
                 | |/ |/ / -_) / __/ _ \\/  ' \\/ -_)  | |/ / -_) _ \\/ /\s
                 |__/|__/\\__/_/\\__/\\___/_/_/_/\\__/   |___/\\__/_//_/_/ \s
                                                                      \s
                """);
    }
}
