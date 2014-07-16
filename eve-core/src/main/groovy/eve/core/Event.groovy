package eve.core

class Event {

    Long id
    String name
    Date startDate
    Date endDate
    String hashtag
    String logo
    List<Tag> tags
    List<Track> tracks
    List<Speaker> speakers

    Map asMap() {
        [
            id: id,
            name: name,
            startDate: startDate,
            endDate: endDate,
            hashtag: hashtag,
            logo: logo,
            tags: tags.collect { it.asMap() },
            tracks: tracks.collect { it.asMap() },
            speakers: speakers.collect { it.asMap() }
        ]
    }

}