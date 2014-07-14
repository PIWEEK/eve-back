package eve.persistence

import eve.Event

interface EventRepository implements Repository {


    def findByName(String name)




}
