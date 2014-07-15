package eve.api.controllers

import javax.servlet.http.HttpServletResponse
import eve.api.either.Either

abstract class BaseController {

    def renderWithResponse(HttpServletResponse response, Either either) {
        response.status = either.code
        return either.getData()
    }

}