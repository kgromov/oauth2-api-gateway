package oauth2.demo.web;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import oauth2.demo.model.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person-service")
public class PersonController {

    @GetMapping("/person")
    public PersonDto getRandomPersonInfo() {
        Name personName = new Faker().name();
        return new PersonDto(personName);
    }
}
