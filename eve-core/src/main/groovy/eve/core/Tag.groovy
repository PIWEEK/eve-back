package eve.core

class Tag {

    Long id
    String name
    Long event_id

    Map asMap() {
        [
            id: id,
            name: name
        ]
    }
}
