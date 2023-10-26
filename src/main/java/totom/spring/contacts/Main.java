package totom.spring.contacts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import totom.spring.contacts.config.AppConfig;
import totom.spring.contacts.config.InitConfig;
import totom.spring.contacts.containers.ContactsContainer;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactsContainer cc = acac.getBean(ContactsContainer.class);
        cc.addContact("Aboba;1234;abobamail@mail.ru");
        cc.addContact("Van Dark;1234;abba@mail.ru");
        cc.printAllContacts();
//        cc.deleteByEmail("abba@mail.ru");
    }
}
