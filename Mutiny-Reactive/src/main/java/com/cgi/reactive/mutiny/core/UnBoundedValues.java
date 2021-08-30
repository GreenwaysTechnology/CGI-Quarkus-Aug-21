package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class UnBoundedValues {
    public static void main(String[] args) {
        Multi.createFrom()
                .ticks()
                .every(Duration.ofMillis(1000))
                .subscribe().with(System.out::println);
    }
}
