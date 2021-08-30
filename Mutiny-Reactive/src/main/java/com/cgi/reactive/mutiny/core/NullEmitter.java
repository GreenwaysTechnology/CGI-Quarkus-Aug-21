package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Uni;

public class NullEmitter {
    public static void main(String[] args) {
       Uni.createFrom().nullItem().subscribe().with(System.out::println);
    }
}
