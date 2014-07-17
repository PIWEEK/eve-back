package eve.core

class Track {

    Long id
    String name
    Long event_id

    Map asMap() {
        [
            id: id,
            name: name,
            event_id: event_id
        ]
    }
}
