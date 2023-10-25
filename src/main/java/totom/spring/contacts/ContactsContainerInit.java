package totom.spring.contacts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactsContainerInit implements ContactsContainer {
    Map<String,Contact> contacts; //ключем сделам email чтобы реализовать удаление по нему
    @Value("${contactsFile.path}")
    String path;
    public ContactsContainerInit(){
        System.out.println(path);
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
    public void addContact(String contact) {
        addContact(new Contact(
                contact.split(";")[0],
                contact.split(";")[1],
                contact.split(";")[2]));
    }

}
