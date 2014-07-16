package eve.persistence

import groovy.sql.Sql
import eve.core.Event

class H2EventRepository implements EventRepository {

    Sql sql = Database.instance.sql

    Event get(Object id) {
        def row = sql.firstRow "select * from events where id=:id", [id:id]
        result[0] as Event
    }

    List<Event> getAll() {
        def res = []
        sql.eachRow "select * from events" {
            res << $it as Event
        }
        res
    }

    List<Event> findAll(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    Event find(Map<String,Object> propertyValuePairs) {
        throw new UnsupportedOperation()
    }

    def put(Object obj) {
        sql.execute """insert into events(id, name, startDate, endDate, hashtag, logo)
            values (?,?,?,?,?,?) """, obj as Map
    }

    def remove(Object obj) {
        events.remove(obj)
    }


    Event findByName(String name) {
        events.find { it.name == name }
    }
}
