package eve.core

import static eve.core.util.DateUtils.formatDate

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
            startDate: formatDate(startDate),
            endDate: formatDate(endDate),
            description: description,
            hashtag: hashtag,
            logo: logo,
            tags: tags,
            lastUpdate: formatDate(lastUpdate),
            tracks: tracks.collect { it.asMap() },
            speakers: speakers.collect { it.asMap() },
            talks: talks.collect { it.asMap() }
        ]
    }

}