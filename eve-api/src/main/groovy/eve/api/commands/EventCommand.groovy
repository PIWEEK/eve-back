package eve.api.commands

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

class EventCommand {

    String name
    Date startDate
    Date endDate
    String owner
    String hashtag
    String logo
    List tags

    Map asMap() {
        [
            name: name,
            startDate: startDate,
            endDate: endDate,
            owner: owner,
            hashtag: hashtag,
            logo: logo,
            tags: tags
        ]
    }

}
