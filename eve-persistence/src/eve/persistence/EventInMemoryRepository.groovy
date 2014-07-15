package eve.persistence

import eve.Event

class EventInMemoryRepository implements EventRepository {

    static Set<Event> events = []

    Object get(Object name) {
        events.find{ it.name == name }
    }

    List getAll() {
        events as List
    }

    Object findByName(String name) {
        events.find{ it.name == name }
    }

    List findAll(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    Object find(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    def put(Object obj) {
        events.add(obj)
    }

    def remove(Object obj) {
        events.remove(obj)
    }
}
