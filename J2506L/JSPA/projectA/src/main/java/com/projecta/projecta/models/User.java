package com.projecta.projecta.models;

import com.projecta.projecta.dtos.requests.user.UserRegisterRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    public static User fromDTO(UserRegisterRequest request) {
        return User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}
