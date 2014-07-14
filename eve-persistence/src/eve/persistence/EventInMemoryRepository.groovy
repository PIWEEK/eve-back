package eve.persistence

import eve.Event

class EventInMemoryRepository implements EventRepository {

    static List<Event> events = []

    def get(Object obj) {
        events.findById(obj.id)

    }

    def put(Object obj) {
        events << obj
    }

    def remove(Object obj)  {
        events.remove(obj)
    }

    def findByName(String name) {
        events.findByName(obj.name)
    }
}
