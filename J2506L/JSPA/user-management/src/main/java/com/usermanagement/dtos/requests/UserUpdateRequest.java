package com.usermanagement.dtos.requests;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateRequest {
    @Size(min = 6, message = "Mật khẩu mới nếu có phải từ 6 ký tự")
    private String password; // Cho phép đổi pass

    private String role; // Thường chỉ Admin mới dùng
}
