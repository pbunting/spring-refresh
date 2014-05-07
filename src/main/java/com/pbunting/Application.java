package com.pbunting.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:appConfig.xml")
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
          new AnnotationConfigApplicationContext();
      context.scan("com.pbunting.app"); // scans com.pbunting and subpackages for beans including @Configuration beans
      context.refresh();
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}

