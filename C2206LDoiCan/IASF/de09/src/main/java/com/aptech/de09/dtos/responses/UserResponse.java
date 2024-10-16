package com.aptech.de09.dtos.responses;

import com.aptech.de09.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;

    private String username;

    private String email;

    private Date createdAt;

    private Date updatedAt;
    //factory method
    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .username(user.getUsername())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
