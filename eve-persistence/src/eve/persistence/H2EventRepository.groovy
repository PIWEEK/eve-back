package eve.persistence

import eve.core.Event

class H2EventRepository implements EventRepository {

    static Set<Map> events = []

    T get(Object id) {
        events.find{ it.name == name }
    }

    List<T> getAll() {
        events as List
    }

    List<T> findAll(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    T find(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    def put(Object obj) {
        events.add(obj)
    }

    def remove(Object obj) {
        events.remove(obj)
    }


    Event findByName(String name) {
        events.find { it.name == name }
    }
}
