package com.example.ProVision_ERP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVision_ERP.Config.JwtService;
import com.example.ProVision_ERP.Dto.LoginRequest;
import com.example.ProVision_ERP.Dto.LoginResponse;
import com.example.ProVision_ERP.Dto.RegisterRequest;
import com.example.ProVision_ERP.Model.User;
import com.example.ProVision_ERP.Services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;

    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome this endpoint is not secure"; 
    } 

    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody RegisterRequest registerRequest) {
        User registeredUser = authService.Signup(registerRequest);

        return ResponseEntity.ok(registeredUser);
    }
    

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

        System.out.println("ingreso al login");
        User authUser = authService.login(loginRequest);
        System.out.println("ingreso authentication");
        String jwtToken = jwtService.generateToken(authUser);
        System.out.println(jwtToken);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
