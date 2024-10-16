package dtos.requests;

import lombok.*;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StudentRegistrationRequest {
    private String name;
    private String address;
    private String phoneNumber;
    private String className;
    

    // Validation method to check if any field is empty
    public boolean isValid() {
        return name != null && !name.isEmpty() &&
               address != null && !address.isEmpty() &&
               phoneNumber != null && !phoneNumber.isEmpty() &&
               className != null && !className.isEmpty();
    }
}

