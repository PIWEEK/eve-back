package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.servlet.http.HttpServletResponse
import static eve.api.either.Either.bind
import eve.api.either.*

@RestController
class EventController extends BaseController {

    @RequestMapping('/event')
    def eventList(HttpServletResponse response) {
        return this.properties
    }

    @RequestMapping('/event-error')
    def eventError(HttpServletResponse response) {
        renderWithResponse response, ([hola:'mundo'] as Left)
    }

}