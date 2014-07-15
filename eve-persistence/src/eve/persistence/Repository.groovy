package eve.persistence

interface Repository {

    Object get(Object id)

    List getAll()

    List findAll(Map<String,Object> propertyValuePairs)

    Object find(Map<String,Object> propertyValuePairs)

    def put(Object obj)

    def remove(Object obj)


}
