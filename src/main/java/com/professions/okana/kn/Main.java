package com.professions.okana.kn;


import com.professions.okana.kn.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        //UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);

        context.close();
    }
}
