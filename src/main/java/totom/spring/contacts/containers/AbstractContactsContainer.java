package totom.spring.contacts.containers;

import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractContactsContainer implements ContactsContainer{
    Map<String, Contact> contacts;
    FileHandler fileHandler;

    public AbstractContactsContainer(FileHandler fileHandler){
        contacts = new HashMap<>();
        this.fileHandler = fileHandler;
    }

    public void inputNewContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input contact in format name; number; email\n");
        addContact(scanner.nextLine());
    }

    public void  printAllContacts(){
        if (contacts.isEmpty()) System.out.println("Contacts container is empty");
        else contacts.forEach((k, v) -> v.printContact());
    }
    public void addContact(Contact contact){
        contacts.put(contact.getEmail(), contact);
        fileHandler.addContact(contact);
    }
    public void addContact(String contactStr){
        if (contactStr.split(";").length == 3){
            Contact contact = new Contact(
                    contactStr.split(";")[0].trim(),
                    contactStr.split(";")[1].trim(),
                    contactStr.split(";")[2].trim()
            );
            contacts.put(contact.getEmail(),contact);
            fileHandler.addContact(contact);
        }else System.out.println("Your string is strange ");
    }
    public void deleteByEmail(String email){
        if (contacts.containsKey(email)) {
            fileHandler.deleteContact(contacts.get(email));
            contacts.remove(email);
            System.out.println("Contact with email: "+email+" deleted successfully");
        }
        else System.out.println("There is no such contact in list");
    }
}
