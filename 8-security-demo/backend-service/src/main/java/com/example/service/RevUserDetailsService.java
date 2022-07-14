package com.example.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("tom")) {
            List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("MEMBER"), new SimpleGrantedAuthority("ADMIN"));
            User user = new User("tom", "12345678", grantedAuthorities);
            return user;
        }else{
            throw new UsernameNotFoundException(username);
        }
    }

}
