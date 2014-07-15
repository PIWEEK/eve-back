package eve.persistence

import eve.core.Event

class InMemoryRepository<T> implements EventRepository {

    static Set<T> events = []

    T get(Object name) {
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
