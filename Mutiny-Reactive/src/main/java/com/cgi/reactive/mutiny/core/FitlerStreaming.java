package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Multi;

public class FitlerStreaming {
    public static void main(String[] args) {
        Multi.createFrom().range(1, 100)
                .select()
                .where(i -> i > 50)
                .select()
                .last(10)
                .select()
                .where(i -> i % 2 != 0)
                .subscribe().with(System.out::println);
    }
}
