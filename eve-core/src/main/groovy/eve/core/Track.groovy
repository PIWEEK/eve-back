package eve.core

class Track {
    String name
    Event event

    Map asMap() {
        [
            name: name,
            event: event
        ]
    }
}
