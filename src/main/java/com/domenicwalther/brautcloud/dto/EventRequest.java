package com.domenicwalther.brautcloud.dto;


import java.time.LocalDateTime;

public record EventRequest(

        Long userId,

        String eventName,

        String location,

        LocalDateTime date,

        String password,

        String qrCode
) {


}
