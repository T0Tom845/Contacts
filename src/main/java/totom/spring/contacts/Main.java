package totom.spring.contacts;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import totom.spring.contacts.config.AppConfig;
import totom.spring.contacts.containers.ContactsContainer;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        Controller cc = acac.getBean(Controller.class);
        cc.showMenu();
        //Write your code here
    }
}
