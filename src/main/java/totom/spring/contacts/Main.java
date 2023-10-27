package totom.spring.contacts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import totom.spring.contacts.config.AppConfig;
import totom.spring.contacts.config.InitConfig;
import totom.spring.contacts.containers.ContactsContainer;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactsContainer cc = acac.getBean(ContactsContainer.class);
        cc.deleteByEmail("someEmail@example.example");
        //Write your code here
    }
}
