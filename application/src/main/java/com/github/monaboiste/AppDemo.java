package com.github.monaboiste;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AppDemo {

    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class, args);
    }

    @Slf4j
    @Component
    @RequiredArgsConstructor
    static class BeansInfo implements CommandLineRunner {

        private final ApplicationContext applicationContext;

        @Override
        public void run(String... args) {
            log.info("------------Beans:");
            for (String beanName : applicationContext.getBeanDefinitionNames()) {
                log.info("->{}", beanName);
            }
            log.info("------------BeansEnd");
        }
    }
}
