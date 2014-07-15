package eve.api.commands

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

class AuthCommand {

    String name
    String password

    Map asMap() {
        [
            name: name,
            password: password
        ]
    }

}
