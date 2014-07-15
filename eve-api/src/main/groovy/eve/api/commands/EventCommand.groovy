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

    Either validate() {
        List<String> errors = []
        if (!name) { errors << 'Name cannot ve blank' }
        if (!owner) { errors << 'Owner cannot ve blank' }
        if (!hashtag) { errors << 'Hashtag cannot ve blank' }
        if (!logo) { errors << 'Logo cannot ve blank' }
        if (!startDate) { errors << 'StartDate cannot ve blank' }
        if (!endDate) { errors << 'EndDate cannot ve blank' }

        if (errors) {
            return [code: 400, errors: errors] as Left
        } else {
            return ([code: 200] + this.asMap()) as Right
        }
    }

}
