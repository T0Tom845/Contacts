package totom.spring.contacts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import totom.spring.contacts.FileHandler;

import java.io.File;


@Configuration
@ComponentScan("totom.spring.contacts")
@PropertySource("classpath:/application.properties")
public class AppConfig {

}
