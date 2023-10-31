package totom.spring.contacts.config;

import org.springframework.context.annotation.*;
import totom.spring.contacts.FileHandler;
import totom.spring.contacts.containers.ContactsContainer;
import totom.spring.contacts.containers.ContactsContainerInit;

@Configuration
@Profile("init")
@ComponentScan("totom.spring.contacts")
public class InitConfig {
    @Bean
    public ContactsContainer ContactsContainerInit(FileHandler fileHandler) {
        return new ContactsContainerInit(fileHandler);
    }
}
