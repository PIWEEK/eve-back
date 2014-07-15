package eve.core.services

import eve.core.Event

class EventService {

    // EventRepository eventRepository = new EventRepository()

    // List<Event> getEventList() {
    //     //return eventRepository.list()
    // }

    Event createEvent(Map data) {
        Event event
        data.with {
            event = new Event(
                name: name,
                startDate: startDate,
                endDate: endDate,
                //owner: owner,
                hashtag: hashtag,
                logo: logo,
                //tags: tags
            )
        }
        // return eventRepository.persist(event)
        // persist must return Event or null
        return event
    }

    Event updateEvent(Map data) {
        Event event
        data.with {
            event = new Event(
                id: id,
                name: name,
                startDate: startDate,
                endDate: endDate,
                //owner: owner,
                hashtag: hashtag,
                logo: logo,
                //tags: tags
            )
        }
        // return eventRepository.persist(event)
        return event
    }

    Boolean deleteEvent(Map data) {
        // return eventRepository.deleteById(data.id)
        return true
    }

}