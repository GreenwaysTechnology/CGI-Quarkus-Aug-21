package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Multi;

public class RangeStream {
    public static void main(String[] args) {
        Multi.createFrom()
                .range(1, 100)
                .onItem().transform(i -> i * 2)
                .subscribe().with(System.out::println);

    }
}
