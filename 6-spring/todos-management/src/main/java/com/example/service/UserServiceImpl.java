package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, String password, String name) {

        // check is user already exist
        User dbUser = userRepository.findByUsername(username);
        if (dbUser != null) {
            throw new IllegalStateException("User already exist");
        }
        // hash password

        // save the user indo
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        Role memberRole = new Role();
        memberRole.setId(1);
        List<Role> roles = List.of(memberRole);
        user.setRoles(roles);

        userRepository.save(user);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userRepository.findByUsername(username);
        List<Role> roles = dbUser.getRoles();
        List<GrantedAuthority> grantedAuthorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(dbUser.getUsername(), dbUser.getPassword(),grantedAuthorities);
        return user;
    }
}
