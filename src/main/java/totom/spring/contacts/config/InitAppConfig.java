package totom.spring.contacts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import totom.spring.contacts.ContactsContainer;

@Configuration
@Profile("init")
@ComponentScan("totom.spring.contacts")
@PropertySource("classpath:application.yaml")
public class InitAppConfig {
    @Bean
    public ContactsContainer contactsContainer(@Value("${file.path}") String path){
        return new ContactsContainer(path);
    }

}