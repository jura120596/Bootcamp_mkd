package com.samsung.service;

import com.samsung.entity.User;
import com.samsung.models.UserDTO;

public interface TokenService {
    String generateToken(User user);

    UserDTO parseToken(String token);
}
