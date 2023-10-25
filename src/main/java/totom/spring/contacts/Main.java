package totom.spring.contacts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import totom.spring.contacts.config.DefaultAppConfig;
import totom.spring.contacts.config.InitAppConfig;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InitAppConfig.class);

        ContactsContainer cc = context.getBean(ContactsContainer.class);
        cc.printAll();
        cc.addContact(new Contact("BillY Harrington", "232424", "defaultEmail.2332@mail.ru" ));
        cc.addContact(new Contact("Van Darkholm", "657345344", "Aloha2@mail.ru" ));

        cc.printAll();

    }
}
