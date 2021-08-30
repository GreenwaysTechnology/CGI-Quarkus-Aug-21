package com.cgi.reactive.mutiny.core;

import io.smallrye.mutiny.Uni;

public class UniDataProcessing {
    public static void main(String[] args) {
        Uni.createFrom()
                .item("Hello")
                //data processing pipe lines
                .onItem().transform(item -> item + " Mutiny")
                // .onItem().transform(item->item.toUpperCase())
                .onItem().transform(String::toUpperCase)
                .subscribe().
                with(System.out::println);

        Uni.createFrom().item(100).onItem().transform(i -> i * 10).subscribe().
                with(System.out::println);
    }
}
