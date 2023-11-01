package totom.spring.contacts;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Component
public class FileHandler {

    private File file;

    public FileHandler(@Value("${file.path}") String path) {
        String userDirectory = System.getProperty("user.dir");
        file = new File(userDirectory, "src/main/" + path);
    }

    public List<String> getContacts() {
        List<String> contacts = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                contacts.add(scanner.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    //ToDo: переписать нормально со Stream
    public boolean isFileContainsContact(Contact contact) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals(contact.toString())) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void addContact(Contact contact) {
        if (!isFileContainsContact(contact)) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write("\n" + contact.toString());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteContact(@NotNull Contact contact) {

        String lineToRemove = contact.toString(); // строка, которую необходимо удалить
        File temp = new File(file.getParent() + "/temp.txt");


        try( BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
             BufferedReader reader1 = new BufferedReader(new FileReader(temp));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(file))){

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {// 1 переписываем все кроме удаляемого в темп
                if (currentLine.equals(lineToRemove)) {
                    continue; // пропускаем строку для удаления
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }



            while ((currentLine = reader1.readLine()) != null) {// 1 переписываем из темп в файл
                if (currentLine.equals(lineToRemove)) {
                    continue; // пропускаем строку для удаления
                }
                writer1.write(currentLine + System.getProperty("line.separator"));
            }


            temp.delete();
            System.out.println("Line " + contact.toString() + " deleted ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


