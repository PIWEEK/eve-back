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
            if (!name) { errors << 'Name cannot be blank' }
            if (!startDate) { errors << 'Start date cannot be blank' }
            if (!endDate) { errors << 'End date cannot be blank' }
            if (!description) { errors << 'Description cannot be blank' }
            if (!hashtag) { errors << 'Hashtag cannot be blank' }
            if (!logo) { errors << 'Logo cannot be blank' }
            if (!tags) { errors << 'Tags cannot be blank' }
            if (!location) { errors << 'Location cannot be blank' }
            if (!location_description) { errors << 'Location description cannot be blank' }
        }

        if (errors) {
            return [code: 400, errors: errors] as Left
        } else {
            return (data + [code: 200]) as Right
        }
    }

    Either getEventList(Map data) {
        def eventList = eventService.getEventList()
        def eventListMap = eventList.collect { it.asMap() }

        return [code: 200, events: eventListMap] as Right
    }

    Either getCompleteEventList(Map data) {
        def eventList = eventService.getCompleteEventList()
        def eventListMap = eventList.collect { it.asMap() }

        return [code: 200, events: eventListMap] as Right
    }

    Either getEventById(Map data) {
        def event = eventService.getEventById(data.id)

        if (event) {
            return (data + [event: event.asMap()] + [code: 200]) as Right
        } else {
            return [code: 500, error: "Event ${data.id} could not be retreived".toString()] as Left
        }
    }

    Either getCompleteEventById(Map data) {
        def event = eventService.getCompleteEventById(data.id)

        if (event) {
            return (data + [event: event.asMap()] + [code: 200]) as Right
        } else {
            return [code: 500, error: "Event ${data.id} could not be retreived".toString()] as Left
        }
    }

    Either createEvent(Map data) {
        Event event = createEventFromMap(data)
        event = eventService.createEvent(event)

        if (event) {
            return (data + [event: event.asMap()] + [code: 200]) as Right
        } else {
            return [code: 500, error: 'Could not create event'] as Left
        }
    }

    Either updateEvent(Map data) {
        Event event = createEventFromMap(data)
        event = eventService.updateEvent(event)

        if (event) {
            return (data + event.asMap() + [code: 200]) as Right
        } else {
            return [code: 500, error: "Could not update event ${data.id}".toString()] as Left
        }
    }

    Either deleteEvent(Map data) {
        Event event = createEventFromMap(data)

        Boolean result = eventService.deleteEvent(event)

        if (result) {
            return (data + [code: 204]) as Right
        } else {
            return [code: 500, error: "Could not delete event ${data.id}".toString()] as Left
        }
    }

    private Event createEventFromMap(Map data) {
        return new Event(
            id: data.id,
            name: data.name,
            startDate: data.startDate,
            endDate: data.endDate,
            hashtag: data.hashtag,
            logo: data.logo,
            tags: data.tags,
            tracks: data.tracks,
            speakers: data.speakers
        )
    }

}
