package com.domenicwalther.brautcloud.controller;

import com.domenicwalther.brautcloud.dto.EventRequest;
import com.domenicwalther.brautcloud.dto.EventResponse;
import com.domenicwalther.brautcloud.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<EventResponse> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping("/events")
    public void addEvent(@RequestBody EventRequest request) {
        eventService.addEvent(request);
    }

}
