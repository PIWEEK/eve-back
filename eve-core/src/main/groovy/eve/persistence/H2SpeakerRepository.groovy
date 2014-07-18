package eve.persistence

import groovy.sql.Sql
import eve.core.Speaker

class H2SpeakerRepository implements SpeakerRepository {

    Sql sql = Database.instance.sql

    Speaker get(Object id) { }

    List<Speaker> getAll() { }

    List<Speaker> findAll(Map<String,Object> propertyValuePairs) { }

    Speaker find(Map<String,Object> propertyValuePairs) { }

    def put(Speaker obj) { }

    def update(Speaker obj) { }

    def remove(Speaker obj) { }

    List<Speaker> findAllByEventId(Long id) {
        def res = []
        sql.eachRow("select * from speaker where event_id=?.id", [id: id]) { row ->
            res << new Speaker(id: row.id, talk_id: row.talk_id, event_id: row.event_id, name: row.name, twitter: row.twitter, bio: row.bio, position: row.position, tags: row.tags, photo: row.photo)
        }
        return res
    }

}