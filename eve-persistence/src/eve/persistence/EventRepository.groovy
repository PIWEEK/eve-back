package eve.persistence

import eve.core.Event

interface EventRepository implements Repository<Event> {

    Event findByName(String name)

}
