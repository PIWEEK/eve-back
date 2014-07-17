package eve.core

class Talk {

    Long id
    Long event_id
    Long track_id
    String name
    Date startDate
    Integer minutes
    String description
    String roomName
    int maxAtendees
    String tags
    String hashtag

    Map asMap() {
        [
            id: id,
            event_id: event_id,
            track_id: track_id,
            name: name,
            startDate: startDate,
            minutes: minutes,
            description: description,
            roomName: roomName,
            maxAtendees: maxAtendees,
            tags: tags,
            hashtag: hashtag
        ]
    }
}
