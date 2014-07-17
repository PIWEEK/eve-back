package eve.core

class Event {

    Long id
    String name
    Date startDate
    Date endDate
    String description
    String hashtag
    String logo
    String tags
    Date lastUpdate

    List<Track> tracks
    List<Track> speakers
    List<Track> talks

    Map asMap() {
        [
            id: id,
            name: name,
            startDate: startDate,
            endDate: endDate,
            hashtag: hashtag,
            logo: logo,
            tags: tags,
            lastUpdate: lastUpdate,
            tracks: tracks.collect { it.asMap() },
            speakers: speakers.collect { it.asMap() },
            talks: talks.collect { it.asMap() }
        ]
    }

}