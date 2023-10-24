package totom.spring.contacts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Бин контейнер или типа того
@Component
public class ContactsContainer {
    Map<String,Contact> contacts; //ключем сделам email чтобы реализовать удаление по нему
    @Autowired
    public ContactsContainer(String path){
        contacts = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(path);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNext()){
                addContact(scan.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Autowired
    public ContactsContainer(){
        contacts = new HashMap<>();
    }
    public void printAll(){
        if (contacts.isEmpty()) System.out.println("There is no contacts in container");
        contacts.forEach((k,v) -> System.out.println(v));
    }
    public void addContact(Contact contact){
        String key = contact.getEmail();
        contacts.put(key, contact);
    }
    public void addContact(String contact){
        addContact(new Contact(
                contact.split(";")[0],
                contact.split(";")[1],
                contact.split(";")[2]));
    }
    public void addContacts(List<String> contacts){
        for (String contact: contacts) {
            addContact(new Contact(
                    contact.split(";")[0],
                    contact.split(";")[1],
                    contact.split(";")[2]));
        }
    }
    public void deleteContactByEmail(String email){
        if(contacts.get(email) != null) {
            contacts.remove(email);
            System.out.println("Contact was removed");
        }
        else System.out.println("Container doesn't contain that contact");
    }

}
