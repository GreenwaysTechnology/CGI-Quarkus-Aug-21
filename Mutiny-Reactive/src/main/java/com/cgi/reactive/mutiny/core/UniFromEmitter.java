package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Uni;

public class UniFromEmitter {
    public static void main(String[] args) {
        Uni.createFrom()
                .emitter(uniEmitter -> {
                    uniEmitter.complete("Hello"); // push event
                    //this will not be emitted becuase it is uni
                    uniEmitter.complete("Hai");
                    uniEmitter.complete("Welcome");
                })
                .subscribe().with(System.out::println, System.out::println);
    }
}
