package eve.persistence

interface Repository {

    def get(Object obj)

    def put(Object obj)

    def remove(Object obj)


}
