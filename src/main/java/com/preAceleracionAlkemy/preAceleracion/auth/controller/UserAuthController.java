package com.preAceleracionAlkemy.preAceleracion.auth.controller;

import com.preAceleracionAlkemy.preAceleracion.auth.dto.AuthenticationRequest;
import com.preAceleracionAlkemy.preAceleracion.auth.dto.AuthenticationResponse;
import com.preAceleracionAlkemy.preAceleracion.auth.dto.UserDto;
;
import com.preAceleracionAlkemy.preAceleracion.auth.service.JwtUtils;
import com.preAceleracionAlkemy.preAceleracion.auth.service.LoginService;
import com.preAceleracionAlkemy.preAceleracion.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse> singUp(@RequestBody UserDto user) throws Error {

        this.userDetailsCustomService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authRequest) throws Exception {

        String jwt = loginService.singIn(authRequest);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
