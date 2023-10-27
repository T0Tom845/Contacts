package totom.spring.contacts.containers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


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
