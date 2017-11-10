package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static String token511 = "e22340b5-2524-4594-a7bd-20c6f34c49d8";
    public static String esUrl = "https://elasticsearch-java.greenfieldlabs.io/";
    public static String opUrl = "http://api.511.org/transit/operators";
    public static String  jur = " http://api.511.org/Jurisdictions";
    public static String es = "https://elasticsearch-java.greenfieldlabs.io/";

    public String[] operators= {"AC Transit", "Caltrain", "Golden Gate Transit", "SFMTA", "VTA", "BART",
            "Marin Transit"};

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
