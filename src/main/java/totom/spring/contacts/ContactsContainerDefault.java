package totom.spring.contacts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

//Бин контейнер или типа того
public class ContactsContainerDefault implements ContactsContainer {
    Map<String,Contact> contacts; //ключем сделам email чтобы реализовать удаление по нему
    public ContactsContainerDefault() {
        contacts = new HashMap<>();
    }

    public void addContact(String contact){
        addContact(new Contact(
                contact.split(";")[0],
                contact.split(";")[1],
                contact.split(";")[2]));
    }
    public void deleteContactByEmail(String email){
        if(contacts.get(email) != null) {
            contacts.remove(email);
            System.out.println("Contact was removed");
        }
        else System.out.println("Container doesn't contain that contact");
    }

}
