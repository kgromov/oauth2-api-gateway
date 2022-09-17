package oauth2.demo.model;

import com.fasterxml.jackson.annotation.*;
import com.github.javafaker.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
/*@JsonIgnoreProperties(allowGetters = true, value = {"address"})
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, fieldVisibility = JsonAutoDetect.Visibility.NONE)*/
// this is all cool with delegates unless you need to serialize fields if getters not defined (like in Faker - city() instead of getCity().
// In this case explicit declaration of getters is required
public class AddressDto {
    @Delegate
    private Address address;

    public String getState() {
        return address.state();
    }

    public String getCountry() {
        return address.country();
    }

    public String getCity() {
        return address.city();
    }

    public String getZipCode() {
        return address.zipCode();
    }

    public String getAddress() {
        return address.fullAddress();
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "address =" + address.fullAddress() +
                '}';
    }
}
