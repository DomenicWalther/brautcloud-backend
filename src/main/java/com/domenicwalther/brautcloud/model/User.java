package com.domenicwalther.brautcloud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class User {

    @Id
    private String id;

    private String lastName;
    private String firstNameCoupleOne;
    private String firstNameCoupleTwo;
    private LocalDateTime created_at;
    private String email;
    private boolean email_verified;
    private String password;
}
