package eve.core.services

import eve.persistence.H2EventRepository
import eve.persistence.EventRepository
import eve.core.Event

class EventService {

    EventRepository eventRepository = new H2EventRepository()

    Event createEvent(Map data) {
        Event event
        data.with {
            event = new Event(
                name: name,
                startDate: startDate,
                endDate: endDate,
                hashtag: hashtag,
                logo: logo,
                tags: tags,
                tracks: tracks,
                speakers: speakers
            )
        }

        return eventRepository.put(event)
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

    List<Event> getEventList() {
	// return eventRepository.list()
	return [
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
    }

    Event getEventById(Long id) {
        // return eventRepository.getEventById(id)
        return new Event(
	    id: id,
            name: 'UX Spain',
            startDate: new Date() -1,
            endDate: new Date()
        )
    }

}
