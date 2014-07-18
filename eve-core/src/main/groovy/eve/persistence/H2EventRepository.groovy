package eve.persistence

import groovy.sql.Sql
import eve.core.Event

class H2EventRepository implements EventRepository {

    Sql sql = Database.instance.sql
    TrackRepository trackRepository = new H2TrackRepository()
    SpeakerRepository speakerRepository = new H2SpeakerRepository()
    TalkRepository talkRepository = new H2TalkRepository()

    Event get(Object id) {
        def row = sql.firstRow("select * from event where id=:id", [id: id])

        return (row ? new Event([id: row.id, name: row.name, startDate: row.start_date, endDate: row.end_date, description: row.description, hashtag: row.hashtag, logo: row.logo, tags: row.tags, lastUpdate: row.last_update, location: row.location, location_description: row.location_description]) : null)
    }

    List<Event> getAll() {
        def res = []
        sql.eachRow("select * from event where end_date >= CURRENT_TIMESTAMP() order by start_date DESC") { row ->
            res << new Event([id: row.id, name: row.name, startDate: row.start_date, endDate: row.end_date, description: row.description, hashtag: row.hashtag, logo: row.logo, tags: row.tags, lastUpdate: row.last_update, location: row.location, location_description: row.location_description])
        }
        return res
    }

    List<Event> fillList(List<Event> events) {
        return events.collect { Event event ->
            return this.fillEvent(event)
        }
    }

    Event fillEvent(Event event) {
        event.tracks = trackRepository.findAllByEventId(event.id)
        event.speakers = speakerRepository.findAllByEventId(event.id)
        event.talks = talkRepository.findAllByEventId(event.id)

        return event        
    }

    List<Event> findAll(Map<String,Object> propertyValuePairs) {
        throw new RuntimeException()
    }

    Event find(Map<String,Object> propertyValuePairs) {
        throw new RuntimeException()
    }

    def put(Event obj) {
        def eventId = sql.executeInsert("insert into event (name, start_date, end_date, hashtag, logo) values (?.name, ?.startDate, ?.endDate, ?.hashtag, ?.logo)",
                                        [name: obj.name, startDate: obj.start_date, endDate: obj.end_date, hashtag: obj.hashtag, logo: obj.logo])

        if (eventId) { obj.id = eventId?.flatten()?.first() }

        return eventId ? obj : null
    }

    def update(Event obj) {
        def row = sql.firstRow("select * from event where id=:id", [id: obj.id])

        if (row) {
            Boolean result = sql.executeUpdate("update event set name=?.name, start_date=?.startDate, end_date=?.endDate, hashtag=?.hashtag, logo=?.logo where id=?.id",
                                               [id: obj.id, name: obj.name, startDate: obj.start_date, endDate: obj.end_date, hashtag: obj.hashtag, logo: obj.logo])
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