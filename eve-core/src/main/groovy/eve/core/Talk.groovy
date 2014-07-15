package eve.core

class Talk {
    String name
    Date startDate
    Date endDate
    Event event
    Track track
    String description
    String hashtag
    List<Speaker> speakers
    List<Tag> tags
    String roomName
    int maxAtendees
    int numAtendees

    Map asMap() {
        [
            name: name,
            startDate: startDate,
            endDate: endDate,
            event: event,
            track: track,
            description: description,
            hashtag: hashtag,
            speakers: speakers.collect { it.asMap() },
            tags: tags.collect { it.asMap() },
            roomName: roomName,
            maxAtendees: maxAtendees,
            numAtendees: numAtendees
        ]
    }
}
