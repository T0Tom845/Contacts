package totom.spring.contacts.containers;

import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.Map;


public class ContactsContainerInit extends AbstractContactsContainer implements ContactsContainer {
    Map<String, Contact> contacts;
    FileHandler fileHandler;
    
    public ContactsContainerInit(FileHandler fileHandler) {
        super(fileHandler);
        if (!fileHandler.getContacts().isEmpty()){
            for (String contactStr: fileHandler.getContacts()) {
                addContact(contactStr);
            }
        }
        else System.out.println("File is empty");
    }
}
