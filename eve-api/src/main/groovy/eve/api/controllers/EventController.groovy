package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletResponse

import static eve.api.either.Either.bind
import eve.api.either.Left
import eve.api.either.Right

@RestController
@RequestMapping('/event')
class EventController extends BaseController {

    @RequestMapping(value = '/', method = RequestMethod.GET)
    def list(HttpServletResponse response) {
        return [description: 'EVENT LIST']
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    def show(@PathVariable Long id, HttpServletResponse response) {
        return [description: ("EVENT SHOW ${id}" as String)]
    }

}