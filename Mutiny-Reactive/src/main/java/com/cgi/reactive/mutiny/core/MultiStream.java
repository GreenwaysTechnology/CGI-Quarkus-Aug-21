package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Multi;

public class MultiStream {
    public static void main(String[] args) {
        Multi.createFrom().items(1, 2, 3, 4, 5)
                .subscribe().with(onData -> {
                    System.out.println("on Data " + onData);
                }, onError -> {
                    System.out.println("On Error" + onError);
                }, () -> {
                    System.out.println("Completed");
                });
        Multi.createFrom().emitter(multiEmitter -> {
            //push values ,errors, complete events
            multiEmitter.emit("Hello");
            multiEmitter.emit("hai");
            multiEmitter.fail(new RuntimeException("OOps"));
            multiEmitter.emit("welcome");
            multiEmitter.complete();

        }).subscribe().with(onData -> {
            System.out.println("on Data " + onData);
        }, onError -> {
            System.out.println("On Error" + onError);
        }, () -> {
            System.out.println("Completed");
        });

        Multi.createFrom().failure(new RuntimeException("oops")).subscribe().with(onData -> {
            System.out.println("on Data " + onData);
        }, onError -> {
            System.out.println("On Error" + onError);
        }, () -> {
            System.out.println("Completed");
        });
        //can we emit null in multi: you cant emit null values
        Multi.createFrom().empty().subscribe().with(onData -> {
            System.out.println("on Data " + onData);
        }, onError -> {
            System.out.println("On Error" + onError);
        }, () -> {
            System.out.println("Completed");
        });

    }
}
