package totom.spring.contacts;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName.trim();
        this.phoneNumber = phoneNumber.trim();
        this.email = email.trim();
    }
    @Override
    public String toString(){
        return fullName+";"+phoneNumber+";"+email;
    }
}
