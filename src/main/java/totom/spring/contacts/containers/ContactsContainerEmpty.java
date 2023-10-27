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
import java.util.Scanner;

public class ContactsContainerEmpty extends AbstractContactsContainer implements ContactsContainer{
    Map<String, Contact> contacts;
    FileHandler fileHandler;

    public ContactsContainerEmpty(FileHandler fileHandler){
        super(fileHandler);
    }

}
