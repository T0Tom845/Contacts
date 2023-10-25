package totom.spring.contacts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import totom.spring.contacts.ContactsContainer;
import totom.spring.contacts.ContactsContainerInit;

@ComponentScan("totom.spring.contacts")
@Configuration
@PropertySource("classpath:application.yaml")
@Profile("init")
public class InitAppConfig {
    @Bean
    public ContactsContainer ContactsContainerInit(){
        return new ContactsContainerInit();
    }
}