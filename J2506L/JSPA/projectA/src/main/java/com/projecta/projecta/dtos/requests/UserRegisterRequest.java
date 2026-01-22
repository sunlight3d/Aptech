package com.projecta.projecta.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projecta.projecta.validations.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@Builder
@PasswordMatches
public class UserRegisterRequest {
    @NotBlank
    @Size(min = 5, message = "Full name phải có ít nhất 5 ký tự")
    @JsonProperty("fullname")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    @NotBlank
    private String email;

    @NotBlank
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank
    private String password; //custom validation

    @NotBlank
    @JsonProperty("retype_password")
    private String retypePassword;

}
