package dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DictionaryApplication{
    private static final Logger log = LoggerFactory.getLogger(DictionaryApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DictionaryApplication.class);
    }
}
