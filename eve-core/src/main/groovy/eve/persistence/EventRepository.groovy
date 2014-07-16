package eve.persistence

import eve.core.Event

interface EventRepository extends Repository<Event> {

    Event findByName(String name)

}
