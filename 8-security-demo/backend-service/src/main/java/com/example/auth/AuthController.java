package com.example.auth;

import com.example.auth.dto.AuthRequest;
import com.example.auth.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;


    @PostMapping(value = "/login")
    public ResponseEntity<?> doLogin(
            @RequestBody AuthRequest authRequest
    ) {

        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            throw e;
        }
        // generate token
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String jwtToken = jwtUtils.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse(jwtToken);
        return ResponseEntity.ok(authResponse);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public AuthResponse authExceptionHandler(Throwable e) {
        AuthResponse authResponse = new AuthResponse(null);
        authResponse.setMessage(e.getMessage());
        return authResponse;
    }

}
