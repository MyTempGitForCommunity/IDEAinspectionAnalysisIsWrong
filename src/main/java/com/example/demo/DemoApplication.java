package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class DemoApplication
{

  final Environment env;

  @Autowired
  public DemoApplication(Environment env)
  {
    this.env = env;
  }

  @PostConstruct
  public void test()
  {
    String property = env.getProperty("hello.world");

    String result = property == null ? "is NULL": "is NOT NULL";



    System.out.println(result);

  }

  public static void main(String[] args)
  {
    SpringApplication.run(DemoApplication.class, args);
  }
}
