package oauth2.demo.web;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import oauth2.demo.model.AddressDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address-service")
public class AddressController {

    @GetMapping("/address")
    public AddressDto getRandomAddress() {
        Address address = new Faker().address();
        return new AddressDto(address);
    }
}
