package totom.spring.contacts.config;

import org.springframework.context.annotation.*;
import totom.spring.contacts.ContactsContainer;

@ComponentScan("totom.spring.contacts")
@Configuration
@PropertySource("classpath:application.yaml")
@Profile("default")
public class DefaultAppConfig {

    @Bean
    public ContactsContainer contactContainer(){
        return new ContactsContainer();
    }
}
