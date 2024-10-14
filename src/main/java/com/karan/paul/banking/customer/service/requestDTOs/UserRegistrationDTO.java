package com.karan.paul.banking.customer.service.requestDTOs;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String name;
    private String email;
    private String password;
}
