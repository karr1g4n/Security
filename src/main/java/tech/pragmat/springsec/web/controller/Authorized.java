package tech.pragmat.springsec.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.pragmat.springsec.config.Jwt.JwtProvider;
import tech.pragmat.springsec.model.MyUser;
import tech.pragmat.springsec.service.UserService;


@RestController
public class Authorized {
    private final UserService userService;

    private final JwtProvider jwtProvider;

    @Autowired
    public Authorized(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }


    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody MyUser user) {

        MyUser users = userService.getUser(user.getName());
        String token=jwtProvider.generateToken(users.getName());
        AuthResponse authResponse=new AuthResponse(token);
        return authResponse;

    }
}
