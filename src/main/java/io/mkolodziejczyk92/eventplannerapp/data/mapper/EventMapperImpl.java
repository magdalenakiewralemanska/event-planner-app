package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Event;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EventMapperImpl implements EventMapper{

    @Override
    public EventDto mapToEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setId( event.getId() );
        eventDto.setName( event.getName() );

        return eventDto;
    }

    @Override
    public Event mapToEvent(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( eventDto.getId() );
        event.setName( eventDto.getName() );

        return event;
    }

    @Override
    public List<EventDto> mapToEventDtoList(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<>( events.size() );
        for ( Event event : events ) {
            list.add( mapToEventDto( event ) );
        }

        return list;
    }
}
