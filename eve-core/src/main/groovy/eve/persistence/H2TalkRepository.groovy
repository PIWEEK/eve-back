package eve.persistence

import groovy.sql.Sql
import eve.core.Talk

class H2TalkRepository implements TalkRepository {

    Sql sql = Database.instance.sql

    Talk get(Object id) { }

    List<Talk> getAll() { }

    List<Talk> findAll(Map<String,Object> propertyValuePairs) { }

    Talk find(Map<String,Object> propertyValuePairs) { }

    def put(Talk obj) { }

    def update(Talk obj) { }

    def remove(Talk obj) { }

    List<Talk> findAllByEventId(Long id) {
        def res = []
        sql.eachRow("select * from talk where event_id=?.id", [id: id]) { row ->
            res << new Talk([id: row.id, event_id: row.event_id, track_id: row.track_id, name: row.name, startDate: row.start_date, minutes: row.minutes, description: row.description, roomName: row.room_name, maxAtendees: row.max_atendees, tags: row.tags, hashtag: row.hashtag])
        }
        return res
    }

}