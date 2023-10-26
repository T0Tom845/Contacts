package totom.spring.contacts.containers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import totom.spring.contacts.Contact;
import totom.spring.contacts.FileHandler;

import java.util.HashMap;
import java.util.Map;
public class ContactsContainerEmpty implements ContactsContainer{
    Map<String, Contact> contacts;
    FileHandler fileHandler;

    public ContactsContainerEmpty(FileHandler fileHandler){
        System.out.println("EMPTY");
        contacts = new HashMap<>();
        this.fileHandler = fileHandler;
    }


    //boilerplate code lies there ↓

    public void  printAllContacts(){
        if (contacts.isEmpty()) System.out.println("Contacts container is empty");
        else contacts.forEach((k, v) -> System.out.println(v));
    }
    public void addContact(Contact contact){
        contacts.put(contact.getEmail(), contact);
        fileHandler.addContact(contact);
    }
    public void addContact(String contactStr){
        if (contactStr.split(";").length >2){
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
        if (contacts.containsKey(email))contacts.remove(email);
        else System.out.println("There is no such contact in list");
    }





}
