package com.domenicwalther.brautcloud.model;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Event {

    @Id
    private String id;
    private String user_id;
    private String event_name;
    @Column(name = "location")
    private String event_location;
    @Column(name = "date")
    private LocalDateTime event_date;
    private String password;
    private String qr_code;
    private LocalDateTime created_at;
}
