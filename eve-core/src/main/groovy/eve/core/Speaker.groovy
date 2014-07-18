package eve.core

class Speaker {

    Long id
    Long talk_id
    Long event_id
    String name
    String twitter
    String bio
    String position
    String tags
    String photo

    Map asMap() {
        [
            id: id,
            talk_id: talk_id,
            event_id: event_id,
            name: name,
            twitter: twitter,
            bio: bio,
            position: position,
            tags: tags,
            photo: photo
        ]
    }
}
