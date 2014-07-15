package eve.api.services

import org.springframework.stereotype.Service
import eve.core.services.EventService

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

@Service
class EventApiService {

    EventService eventService = new EventService()

    Either getEventList(Map data) {
        def eventList = eventService.getEventList()
        def eventMap = eventList.collect { Event event ->
            event.asMap()
        }

        return [code: 200, events: eventMap] as Right
    }

}