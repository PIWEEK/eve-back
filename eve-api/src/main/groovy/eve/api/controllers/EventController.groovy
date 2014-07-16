package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletResponse

import static eve.api.either.Either.bind
import eve.api.either.Left
import eve.api.either.Right

import eve.api.services.AuthService
import eve.api.services.EventApiService

@RestController
@RequestMapping('/event')
class EventController extends BaseController {

    @Autowired EventApiService eventApiService

    @RequestMapping(value = '', method = RequestMethod.GET)
    def list(HttpServletResponse response) {
        renderWithResponse response, bind(EMPTY, eventApiService.&getEventList)
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    def show(@PathVariable Long id, HttpServletResponse response) {
        def right = [id: id] as Right

        renderWithResponse response, bind(right, eventApiService.&getEventById)
    }

    @RequestMapping(value = '/{id}/complete', method = RequestMethod.GET)
    def showComplete(@PathVariable Long id, HttpServletResponse response) {
        return [description: ("=== complete event ${id}" as String)]
    }

    @RequestMapping(value = '/{id}/speaker', method = RequestMethod.GET)
    def eventSpeakers(@PathVariable Long id, HttpServletResponse response) {
        return [description: ("EVENT ${id} SPEAKERS" as String)]
    }

    @RequestMapping(value = '/{id}/talk', method = RequestMethod.GET)
    def eventTalks(@PathVariable Long id, HttpServletResponse response) {
        return [description: ("EVENT ${id} TALKS" as String)]
    }

}
