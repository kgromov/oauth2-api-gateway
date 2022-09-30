package oauth2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PersonResourseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonResourseServerApplication.class, args);
    }

}
