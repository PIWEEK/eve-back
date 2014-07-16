package eve.core

class Speaker {

    Long id
    Event event
    String name
    String twitter
    String bio
    String photo

    Map asMap() {
        [
            id: id,
            event_id: event.id,
            name: name,
            twitter: twitter,
            bio: bio,
            photo: photo
        ]
    }
}
