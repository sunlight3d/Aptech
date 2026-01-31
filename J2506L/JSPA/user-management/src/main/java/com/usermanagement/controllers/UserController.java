package com.usermanagement.controllers;

import com.usermanagement.dtos.requests.UserUpdateRequest;
import com.usermanagement.dtos.responses.UserResponse;
import com.usermanagement.models.User;
import com.usermanagement.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    // ADMIN: Lấy danh sách DTO thay vì Entity
    // Chỉ ADMIN mới có quyền xem tất cả users
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAll() {
        return service.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    // Hàm helper convert (Có thể dùng ModelMapper hoặc MapStruct nếu dự án lớn)
    private UserResponse convertToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
    // ADMIN hoặc chính người dùng đó mới có quyền xem (nếu bạn muốn nâng cao)
    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse getById(@PathVariable Long id) {
        return convertToResponse(service.findById(id));
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN') or @userService.isOwner(#id, authentication.name)")
    //Nếu chỉnh sửa user đang đăng nhập thì được => "TÔI sửa thông tin của TÔI"
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest req) {
        User updatedUser = service.update(id, req);
        return convertToResponse(updatedUser);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}")
    //KO XÓA CỨNG, chỉ update cột deleted trong User
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



    // USER: Lấy thông tin cá nhân
    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public UserResponse me(Authentication auth) {
        // auth.getName() trả về username từ JWT
        User user = service.findByUsername(auth.getName());
        return convertToResponse(user);
    }
}
/*
BASE_URL="http://localhost:7080"
TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyX3Rlc3RfMDEiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzY5MjQ3MjI0LCJleHAiOjE3NzE4MzkyMjR9.PXOcpN88KvZRuUYF_CVhxHvwcnDsLBzqd8Am5xua6JE"
USER_ID=1


GET /users – ADMIN ONLY
curl -i -X GET "$BASE_URL/api/users" \
  -H "Authorization: Bearer $TOKEN"
👉 -i = include response headers
Tức là in cả HTTP headers + body ra terminal.


GET /users/{id} – ADMIN ONLY
curl -i -X GET "$BASE_URL/api/users/$USER_ID" \
  -H "Authorization: Bearer $TOKEN"


curl -i -X PUT "$BASE_URL/api/users/$USER_ID" \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user_test_updated",
    "role": "ROLE_USER"
  }'

curl -i -X DELETE "$BASE_URL/api/users/$USER_ID" \
  -H "Authorization: Bearer $TOKEN"

* */
