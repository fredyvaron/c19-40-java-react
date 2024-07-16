package com.example.ProVision_ERP.Dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClientCreate {
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String address;
}
