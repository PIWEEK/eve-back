package eve.core.services

import eve.core.Event

class EventService {

    // EventRepository eventRepository = new EventRepository()

    // List<Event> getEventList() {
    //     //return eventRepository.list()
    // }

    Event createEvent(Map data) {
        data.with {
            Event event = new Event(
                name: name,
                startDate: startDate,
                endDate: endDate,
                owner: owner,
                hashtag: hashtag,
                logo: logo,
                tags: tags
            )
        }
        // return eventRepository.persist(event)
        // persist must return Event or null
        return event
    }

}