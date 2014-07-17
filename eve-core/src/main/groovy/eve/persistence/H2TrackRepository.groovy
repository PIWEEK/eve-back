package eve.persistence

import groovy.sql.Sql
import eve.core.Track

class H2TrackRepository implements TrackRepository {

    Sql sql = Database.instance.sql

    Track get(Object id) { }

    List<Track> getAll() { }

    List<Track> findAll(Map<String,Object> propertyValuePairs) { }

    Track find(Map<String,Object> propertyValuePairs) { }

    def put(Track obj) { }

    def update(Track obj) { }

    def remove(Track obj) { }

    List<Track> findAllByEventId(Long id) {
        def res = []
        sql.eachRow("select * from track where event_id=?.id", [id: id]) { row ->
            res << new Track(id: row.id, event_id: row.event_id, name: row.name)
        }
        return res
    }

}