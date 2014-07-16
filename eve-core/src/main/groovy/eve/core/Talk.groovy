package eve.core

class Talk {

    Long id
    Event event
    String name
    Date startDate
    Date endDate
    Track track
    String description
    String hashtag
    List<Speaker> speakers
    List<Tag> tags
    String roomName
    int maxAtendees

    Map asMap() {
        [
            id: id,
            event_id: event.id,
            name: name,
            startDate: startDate,
            endDate: endDate,
            track_id: track.id,
            description: description,
            hashtag: hashtag,
            speakers: speakers.collect { it.id },
            tags: tags.collect { it.asMap() },
            roomName: roomName,
            maxAtendees: maxAtendees
        ]
    }
}
