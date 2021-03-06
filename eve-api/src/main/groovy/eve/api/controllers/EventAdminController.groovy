package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

import static eve.api.either.Either.bind
import eve.api.either.Left
import eve.api.either.Right

import eve.api.services.AuthService
import eve.api.services.EventApiService
import eve.api.commands.EventCommand

@RestController
@RequestMapping('/admin/event')
class EventAdminController extends BaseController {

    @Autowired EventApiService eventApiService
    @Autowired AuthService authService

    @RequestMapping(value = '', method = RequestMethod.POST)
    def create(@RequestBody EventCommand cmd, HttpServletRequest request, HttpServletResponse response) {
        Right right = this.getTokenRightFromHeader(request) + cmd.asMap() + [include: ['event']]

        renderWithResponse response, bind(right,
                                          authService.&validateToken,
                                          eventApiService.&validateEventCommand,
                                          eventApiService.&createEvent)
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.PUT)
    def update(@PathVariable Long id, @RequestBody EventCommand cmd, HttpServletRequest request, HttpServletResponse response) {
        Right right = this.getTokenRightFromHeader(request) + cmd.asMap() + [id: id]

        renderWithResponse response, bind(right,
                                         authService.&validateToken,
                                         eventApiService.&validateEventCommand,
                                         eventApiService.&updateEvent)
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.DELETE)
    def delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        Right right = this.getTokenRightFromHeader(request) + [id: id]

        renderWithResponse response, bind(right,
                                         authService.&validateToken,
                                         eventApiService.&deleteEvent)
    }

}