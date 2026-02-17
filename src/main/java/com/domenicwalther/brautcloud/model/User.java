package com.domenicwalther.brautcloud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;

    private String lastName;

    private String firstNameCoupleOne;

    private String firstNameCoupleTwo;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createdAt;

    private String email;
    private boolean emailVerified;
    private String password;
}
