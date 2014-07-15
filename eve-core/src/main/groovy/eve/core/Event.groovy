package eve.core

class Event {

    Long id
    String name
    Date startDate
    Date endDate
    User owner
    String hashtag
    String logo
    List<Tag> tags

    Map asMap() {
        [
            id: id,
            name: name,
            startDate: startDate,
            endDate: endDate,
            owner: owner,
            hashtag: hashtag,
            logo: logo,
            tags: tags.collect { it.asMap() },
        ]
    }

}
