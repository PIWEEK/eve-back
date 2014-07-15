package eve.core

class Track {

    Long id
    String name
    Event event

    Map asMap() {
        [
            id: id,
            name: name,
            event: event
        ]
    }
}
