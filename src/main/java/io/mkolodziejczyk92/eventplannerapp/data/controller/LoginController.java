package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.constant.SecurityConstant;
import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.model.UserPrincipal;
import io.mkolodziejczyk92.eventplannerapp.data.security.token.JwtProvider;
import io.mkolodziejczyk92.eventplannerapp.data.service.impl.UserPrincipalService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "/user"})
public class LoginController {

    private final UserPrincipalService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;

    public LoginController(UserPrincipalService userService, AuthenticationManager authenticationManager,
                           JwtProvider tokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        authenticate(user.getUsername(), user.getPassword());
        User loginUser = userService.findUserByUsername(user.getUsername());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders headers = getHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, headers, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    private HttpHeaders getHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(SecurityConstant.TOKEN_HEADER, tokenProvider.generateToken(user));
        return headers;
    }
}
