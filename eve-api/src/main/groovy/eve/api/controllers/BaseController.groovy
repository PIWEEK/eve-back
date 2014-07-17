package eve.api.controllers

import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import eve.api.either.Either
import eve.api.either.Right

abstract class BaseController {

    final Right EMPTY = [:] as Right

    def renderWithResponse(HttpServletResponse response, Either either) {
        response.status = either.code

        Map data = either.getData()
        List<String> include = data.include
        if (include) {
            data = data.findAll { k, v -> include.contains(k) }
        }

        return data
    }

    Either getTokenRightFromHeader(HttpServletRequest request) {
        String token = request.getHeader('Authorization')

        return [token: token, code: 200] as Right
    }

}