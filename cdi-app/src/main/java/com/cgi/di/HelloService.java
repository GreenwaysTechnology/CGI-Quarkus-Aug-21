package com.cgi.di;

import javax.enterprise.context.ApplicationScoped;

//bean
@ApplicationScoped
public class HelloService {

      public String sayHello(){
           return "Hello Service Bean";
      }
}
