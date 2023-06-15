package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.EventDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(summary = "Return list of events")
    @GetMapping
    public List<EventDto> getEvents(){
        return eventService.getAllEvents();
    }
    @PostMapping
    public void createEvent(@RequestBody EventDto eventDto){
        eventService.createEvent(eventDto);
    }

    @PutMapping()
    public void updateEvent(@RequestBody EventDto eventDto){
        eventService.updateEvent(eventDto);
    }

    @DeleteMapping()
    public void deleteEvent(@RequestBody EventDto eventDto){
        eventService.deleteEvent(eventDto);
    }
}
