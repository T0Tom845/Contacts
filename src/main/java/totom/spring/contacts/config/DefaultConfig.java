package totom.spring.contacts.config;

import org.springframework.context.annotation.*;
import totom.spring.contacts.FileHandler;
import totom.spring.contacts.containers.ContactsContainer;
import totom.spring.contacts.containers.ContactsContainerEmpty;

@Configuration
@ComponentScan("totom.spring.contacts")
@Profile("default")
public class DefaultConfig {
    @Bean
    public ContactsContainer ContactsContainerEmpty(FileHandler fileHandler){
        return new ContactsContainerEmpty(fileHandler);
    }

}
