package eve.api.commands

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

class AuthCommand {

    String username
    String password

    Map asMap() {
        [
            username: username,
            password: password
        ]
    }

}
