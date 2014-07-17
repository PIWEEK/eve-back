package eve.persistence

import groovy.sql.Sql
import eve.core.Event
import eve.core.Tag

class H2EventRepository implements EventRepository {

    Sql sql = Database.instance.sql
    TagRepository tagRepository = new H2TagRepository()

    Boolean init() {
        sql.execute('create table event(id bigint primary key auto_increment, name varchar, startDate timestamp, endDate timestamp, hashtag varchar, logo varchar)')
    }

    Event get(Object id) {
        def row = sql.firstRow("select * from event where id=:id", [id: id])

        return (row ? new Event([id: row.id, name: row.name, startDate: row.startDate, endDate: row.endDate, hashtag: row.hashtag, logo: row.logo]) : null)
    }

    List<Event> getAll() {
        def res = []
        sql.eachRow("select * from event") { row ->
            res << new Event([id: row.id, name: row.name, startDate: row.startDate, endDate: row.endDate, hashtag: row.hashtag, logo: row.logo])
        }
        return res
    }

    List<Event> findAll(Map<String,Object> propertyValuePairs) {
        throw new RuntimeException()
    }

    Event find(Map<String,Object> propertyValuePairs) {
        throw new RuntimeException()
    }

    def put(Event obj) {
        def eventId = sql.executeInsert("insert into event (name, startDate, endDate, hashtag, logo) values (?.name, ?.startDate, ?.endDate, ?.hashtag, ?.logo)",
                                        [name: obj.name, startDate: obj.startDate, endDate: obj.endDate, hashtag: obj.hashtag, logo: obj.logo])

        if (eventId) { obj.id = eventId?.flatten()?.first() }

        return eventId ? obj : null
    }

    def update(Event obj) {
        def row = sql.firstRow("select * from event where id=:id", [id: obj.id])

        if (row) {
            Boolean result = sql.executeUpdate("update event set name=?.name, startDate=?.startDate, endDate=?.endDate, hashtag=?.hashtag, logo=?.logo where id=?.id",
                                               [id: obj.id, name: obj.name, startDate: obj.startDate, endDate: obj.endDate, hashtag: obj.hashtag, logo: obj.logo])
            return result ? obj : null
        } else {
            return null
        }
    }

    def remove(Event obj) {
        return sql.execute("delete from event where id=?.id", [id: obj.id])
    }

    Event findByName(String name) {
        events.find { it.name == name }
    }
}