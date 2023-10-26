package totom.spring.contacts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Component
public class FileHandler {

    private File file;
    public FileHandler(@Value("${file.path}") String path){
        String userDirectory = System.getProperty("user.dir");
        file = new File(userDirectory, "src/main/" + path);
    }
    public List<String> getContacts(){
        List<String> contacts = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                contacts.add(scanner.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
    //ToDo: переписать нормально со Stream
    public boolean isFileContainsContact(Contact contact){
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                if (scanner.nextLine().equals(contact.toString())){
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void addContact(Contact contact){
        if (!isFileContainsContact(contact)){
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write("\n"+contact.toString());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
