package org.acme;


import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Optional;
//import org.eclipse.microprofile.config.inject.ConfigProperty;

//@ConfigProperties(prefix = "cust")
//public class CustomerConfiguration {
//    @ConfigProperty(name = "name", defaultValue = "default Customer Name")
//    public String name;
//}
//@ConfigMapping(prefix = "cust")
//public interface CustomerConfiguration {
//    @WithName("name")
//    Optional<String> name();
//    Address  address();
//    interface Address{
//        Optional<String> city();
//    }
//}
@ConfigMapping(prefix = "cust")
public interface CustomerConfiguration {
    @WithName("firstName")
    Optional<String> name();
    Address address();
    //inner type
    interface Address {
        Optional<String> city();
    }
}
