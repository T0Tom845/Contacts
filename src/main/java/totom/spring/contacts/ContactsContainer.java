package totom.spring.contacts;

import java.util.HashMap;
import java.util.Map;

public interface ContactsContainer {
    Map<String, Contact> contacts = new HashMap<>();
    public default void addContact(Contact contact){
        String key = contact.getEmail();
        contacts.put(key, contact);
    }
    public default void printAll(){
        if (contacts.isEmpty()) System.out.println("There is no contacts in container");
        contacts.forEach((k,v) -> System.out.println(v));
    }


}
