package com.domenicwalther.brautcloud.controller;

import com.domenicwalther.brautcloud.model.Event;
import com.domenicwalther.brautcloud.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public Collection<Event> getEvents(){
        return eventService.getEvents();
    }

    @PostMapping("/events")
    public void addEvent(@RequestBody Event event){
        eventService.addEvent(event);
    }

}
