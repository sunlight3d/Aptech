package com.aptech.de01.viewmodels.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginViewModel {
    private String username;
    private String password;
}
