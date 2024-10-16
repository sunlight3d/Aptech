package com.aptech.bookapp.viewmodels;

import jakarta.persistence.Column;
import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginViewModel {
    //request object
    //input validation
    private String username;
    private String password;
}
