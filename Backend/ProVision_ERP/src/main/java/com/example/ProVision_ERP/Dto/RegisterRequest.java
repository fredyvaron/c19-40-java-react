package com.example.ProVision_ERP.Dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String passWord;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String rol;
}
