package com.domenicwalther.brautcloud.service;

import com.domenicwalther.brautcloud.model.Event;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {

    Map<String, Event> events = new HashMap<>();

    public Collection<Event> getEvents(){
        return events.values();
    }

    public void addEvent(Event event){
        events.put(event.getId(), event);
    }
}
