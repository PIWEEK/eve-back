package eve.api.controllers

import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import eve.api.either.Either
import eve.api.either.Right

abstract class BaseController {

    def renderWithResponse(HttpServletResponse response, Either either) {
        response.status = either.code
        return either.getData()
    }

    Either getTokenRightFromHeader(HttpServletRequest request) {
        String token = request.getHeader('Authorization')

        return [token: token, code: 200] as Right
    }

}