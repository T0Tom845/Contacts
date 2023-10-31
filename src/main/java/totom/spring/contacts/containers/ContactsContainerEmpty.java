package totom.spring.contacts.containers;

import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.Map;

public class ContactsContainerEmpty extends AbstractContactsContainer implements ContactsContainer{
    Map<String, Contact> contacts;
    FileHandler fileHandler;

    public ContactsContainerEmpty(FileHandler fileHandler){
        super(fileHandler);
    }

}
