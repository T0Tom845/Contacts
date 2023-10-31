package totom.spring.contacts;

import org.springframework.stereotype.Component;
import totom.spring.contacts.containers.ContactsContainer;

import java.util.Scanner;
@Component
public class Controller {

    private FileHandler fileHandler;
    private ContactsContainer contactsContainer;

    public Controller(FileHandler fileHandler, ContactsContainer contactsContainer){
        this.fileHandler = fileHandler;
        this.contactsContainer = contactsContainer;
    }

    public void showMenu(){
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотреть все контакты");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("0. Выход");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> contactsContainer.printAllContacts();
                case 2 -> contactsContainer.inputNewContact();
                case 3 -> {
                    System.out.println("Введите email контакта который хотите удалить");
                    String email = scanner.nextLine();
                    email = scanner.nextLine();
                    contactsContainer.deleteByEmail(email);
                }
                case 0 -> {
                    isRunning = false;
                    System.out.println("Завершаем работу");
                }
                default -> System.out.println("Wrong input");
            }
        }
    }
}
