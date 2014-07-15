package eve.api.services

import org.springframework.stereotype.Service
import eve.core.services.EventService
import eve.core.Event

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

@Service
class EventApiService {

    EventService eventService = new EventService()

    Either getEventList(Map data) {
        // def eventList = eventService.getEventList()
        def eventList = [
            new Event(
                name: 'Greach 2014',
                startDate: new Date() -1,
                endDate: new Date()
            ),
            new Event(
                name: 'Codemotion',
                startDate: new Date() -1,
                endDate: new Date()
            ),
            new Event(
                name: 'UX Spain',
                startDate: new Date() -1,
                endDate: new Date()
            )
        ]
        def eventListMap = eventList.collect { it.asMap() }

        return [code: 200, events: eventListMap] as Right
    }

}