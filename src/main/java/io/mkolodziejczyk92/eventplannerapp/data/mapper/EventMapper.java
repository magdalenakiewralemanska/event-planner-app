package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Event;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.EventDto;

import java.util.List;


public interface EventMapper {

    EventDto mapToEventDto(Event event);

    Event mapToEvent(EventDto eventDto);

    List<EventDto> mapToEventDtoList(List<Event> events);
}
