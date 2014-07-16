package eve.persistence

interface Repository<T> {

    T get(Object id)

    List<T> getAll()

    List<T> findAll(Map<String,Object> propertyValuePairs)

    T find(Map<String,Object> propertyValuePairs)

    def put(T obj)

    def remove(T obj)


}
