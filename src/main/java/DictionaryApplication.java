import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class DictionaryApplication extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(DictionaryApplication.class);

    public static void main(String[] args) {
        log.info("Starting application");
        DictionaryApplication.run(DictionaryApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DictionaryApplication.class);
    }
}