package com.cgi.di;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookService {

    //Inject interface
    @Inject
    NumberGenerator numberGenerator;

    //biz method
    public Book createBook() {
        Book book = new Book("Quarks In Action", 1000f, "Subramanian");
        book.setIsbn(numberGenerator.generateNumber());
        return book;
    }
}
