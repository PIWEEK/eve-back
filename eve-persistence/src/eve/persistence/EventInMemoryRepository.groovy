package eve.persistence

import eve.core.Event

class EventInMemoryRepository implements EventRepository
    extends InMemoryRepository<Event> {

    Event findByName(String name) {
        events.find { it.name == name }
    }
}
