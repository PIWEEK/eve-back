package eve.core.services

import eve.persistence.H2EventRepository
import eve.persistence.EventRepository
import eve.core.Event

class EventService {

    EventRepository eventRepository = new H2EventRepository()

    Event createEvent(Event event) {
        return eventRepository.put(event)
    }

    Event updateEvent(Event event) {
        return eventRepository.update(event) ?: null
    }

    Boolean deleteEvent(Event event) {
        return eventRepository.remove(event)
    }

    List<Event> getEventList() {
        return eventRepository.getAll()
    }

    List<Event> getCompleteEventList() {
        List<Event> events = this.getEventList()
        return eventRepository.fillList(events)
    }

    Event getEventById(Long id) {
        return eventRepository.get(id)
    }

    Event getCompleteEventById(Long id) {
        Event event = this.getEventById(id)
        return eventRepository.fillEvent(event)
    }

}
