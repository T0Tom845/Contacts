package totom.spring.contacts.containers;

import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.HashMap;
import java.util.Map;

public interface ContactsContainer {
    Map<String, Contact> contacts = null;
    FileHandler fileHandler = null;
    void inputNewContact();
    void printAllContacts();
    void addContact(Contact contact);
    void addContact(String contactStr);
    void deleteByEmail(String email);

}
