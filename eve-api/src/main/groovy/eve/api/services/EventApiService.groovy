package eve.api.services

import org.springframework.stereotype.Service

import eve.core.services.EventService
import eve.core.Event
import eve.api.commands.EventCommand

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

@Service
class EventApiService {

    EventService eventService = new EventService()

    Either validateEventCommand(Map data) {
        List<String> errors = []

        data.with {
            if (!name) { errors << 'Name cannot ve blank' }
            if (!owner) { errors << 'Owner cannot ve blank' }
            if (!hashtag) { errors << 'Hashtag cannot ve blank' }
            if (!logo) { errors << 'Logo cannot ve blank' }
            if (!startDate) { errors << 'StartDate cannot ve blank' }
            if (!endDate) { errors << 'EndDate cannot ve blank' }
        }

        if (errors) {
            return [code: 400, errors: errors] as Left
        } else {
            return (data + [code: 200]) as Right
        }
    }

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

    Either createEvent(Map data) {
        Event event = eventService.createEvent(data)
    }

}