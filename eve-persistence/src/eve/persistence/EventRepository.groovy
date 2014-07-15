package eve.persistence

import eve.Event

interface EventRepository implements Repository {


    List findByName(String name)



}
