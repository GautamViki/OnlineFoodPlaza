package com.masai.service;

import com.masai.entity.Login;
import org.springframework.stereotype.Service;

@Service
public interface LogInService {
    public Login signIn(Login login);

    public Login signOut(Login login);
}
