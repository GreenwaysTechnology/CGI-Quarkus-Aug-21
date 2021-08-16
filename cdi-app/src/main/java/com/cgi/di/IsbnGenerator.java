package com.cgi.di;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class IsbnGenerator implements NumberGenerator {
    @Override
    public String generateNumber() {
        return "15-87654" + Math.abs(new Random().nextInt());
    }
}
