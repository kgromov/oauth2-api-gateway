package oauth2.demo.model;

import com.github.javafaker.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
   private String fullName;
   private String bloodGroup;

    public PersonDto(Name personName) {
        this.fullName = personName.fullName();
        this.bloodGroup = personName.bloodGroup();
    }
}
