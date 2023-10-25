package totom.spring.contacts.config;

import org.springframework.context.annotation.*;
import totom.spring.contacts.ContactsContainer;
import totom.spring.contacts.ContactsContainerDefault;

@ComponentScan("totom.spring.contacts")
@Configuration
@PropertySource("classpath:application.yaml")
@Profile("default")
public class DefaultAppConfig {

    @Bean
    public ContactsContainer ContactsContainerDefault(){
        return new ContactsContainerDefault();
    }
}
