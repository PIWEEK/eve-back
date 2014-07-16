package eve.persistence

import groovy.sql.Sql
import eve.core.Event

class H2EventRepository implements EventRepository {

    Sql sql = Database.instance.sql

    Event get(Event id) {
        def row = sql.firstRow "select * from event where id=:id", [id:id]
        result[0] as Event
    }

    List<Event> getAll() {
        def res = []
        sql.eachRow "select * from event" {
            res << $it as Event
        }
        res
    }

    List<Event> findAll(Map<String,Event> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    Event find(Map<String,Event> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    def put(Event obj) {
        sql.execute("insert into event (name, startDate, endDate, hashtag, logo) values (?.name, ?.startDate, ?.endDate, ?.hashtag, ?.logo)",
                    [name: obj.name, startDate: obj.startDate, endDate: obj.endDate, hashtag: obj.hashtag, logo: obj.logo])
    }

    def remove(Event obj) {
        events.remove(obj)
    }


    Event findByName(String name) {
        events.find { it.name == name }
    }
}