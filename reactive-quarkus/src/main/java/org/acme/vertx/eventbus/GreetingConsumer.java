package org.acme.vertx.eventbus;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingConsumer {

    //method which
    @ConsumeEvent(EventBusAddress.CGI_GREETINGS)
    public void handler(Message<JsonObject> name) {
        System.out.println(name.body().encodePrettily());
    }
}
