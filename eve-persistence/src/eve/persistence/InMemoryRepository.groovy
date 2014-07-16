package eve.persistence

abstract class InMemoryRepository<T> implements EventRepository<T> {

    static Set<T> events = []

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

}
