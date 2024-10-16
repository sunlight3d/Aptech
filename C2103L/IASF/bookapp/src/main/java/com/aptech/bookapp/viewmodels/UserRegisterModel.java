package com.aptech.bookapp.viewmodels;

import com.aptech.bookapp.validations.PasswordMatches;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches(message = "password does not match")
public class UserRegisterModel {
    @Size(min = 3, message = "Username must be at least 3 characters long.")
    private String username;

    private String password;

    @NotNull
    private String retypePassword;

    @NotNull(message = "Date of birth must be provided.")
    //private java.util.Date dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
}
