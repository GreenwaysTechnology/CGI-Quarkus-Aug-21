package com.cgi.hasa;

public class Main {
    public static void main(String[] args) {
        //Steps :
        //1.create objects
        //2.Link the objects
        Product product = new Product(1,"Book");
        Order order = new Order(1,1000,product);
        System.out.println(order);
    }
}
