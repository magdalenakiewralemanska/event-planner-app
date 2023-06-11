package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.EventDto;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto);

    void deleteEvent(EventDto eventDto);

    void updateEvent(EventDto eventDto);

    List<EventDto> getAllEvents();

}
