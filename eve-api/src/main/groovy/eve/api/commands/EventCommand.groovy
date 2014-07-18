package eve.api.commands

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

class EventCommand {

    String name
    Date startDate
    Date endDate
    String description
    String hashtag
    String logo
    String tags
    Date lastUpdate
    String location
    String location_description


    Map asMap() {
        [
            name: name,
            startDate: formatDate(startDate),
            endDate: formatDate(endDate),
            description: description,
            hashtag: hashtag,
            logo: logo,
            tags: tags,
            lastUpdate: formatDate(lastUpdate),
            location: location,
            location_description: location_description,
        ]
    }

}
