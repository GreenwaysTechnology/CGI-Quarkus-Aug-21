package org.acme;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreeterService {

    public String sayHello() {
        //i am blocking the event loop
        try {
            //instead of thread.sleep, you may call third party apis.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello,I am delayed";
    }
}
