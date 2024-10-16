package com.aptech.de01.services.user;

import org.springframework.stereotype.Service;


public interface UserService {
    Boolean login(String username, String password);
}
