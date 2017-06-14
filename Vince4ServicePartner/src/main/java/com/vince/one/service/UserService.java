package com.vince.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vince.one.dao.SecurityDb;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private SecurityDb  securityDb;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = securityDb.getUserByname(s);
        return user;
    }
}
