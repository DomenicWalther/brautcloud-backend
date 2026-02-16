package com.domenicwalther.brautcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EventController {

    Map<String, Event> events = new HashMap<>();


    @GetMapping("/events")
    public Collection<Event> getEvents(){
        return events.values();
    }

    @PostMapping("/events")
    public void addEvent(@RequestBody Event event){
        events.put(event.getId(), event);
    }

}
