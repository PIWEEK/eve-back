package eve.api.controllers

import eve.api.either.Either

abstract class BaseController {

    static Either bind(Either either, Closure... methods) {
        Either.bind(Either either, Closure... methods)
    }

    def renderEither(Either either) {
        response.status = either.data.code

        if (either.isLeft()) {
            //render either.data.errors as JSON
        } else {
            //render either.data.info as JSON
        }
    }

}