package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Uni;

public class HelloMutiny {
    public static void main(String[] args) {
        //Create Uni Object from Item
        //item which represents data source
        Uni.createFrom()
                .item("hello")
                .subscribe().with(data -> System.out.println(data)); //lambda expression
        //create uni object from the item which will be emitted when ever subscribe is called
        Uni.createFrom().item(1)
                .subscribe().with(System.out::println); // method reference
        //if you dont call subscribe , item never will be emitted -
        //items will be emitted only on subscription
        Uni.createFrom().item("welcome");

        //emit error
        Uni.createFrom().failure(new RuntimeException("something went wrong"))
                .subscribe().with(data -> {
                    System.out.println("data");
                }, err -> {
                    System.out.println("error");
                    System.out.println(err.getMessage());
                });
        //Uni from scratch.


    }
}
