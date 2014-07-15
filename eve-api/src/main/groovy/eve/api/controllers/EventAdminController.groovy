package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletResponse

import static eve.api.either.Either.bind

import eve.api.either.Left
import eve.api.either.Right

import eve.api.services.AuthService
import eve.api.services.EventApiService
import eve.api.commands.EventCommand

@RestController
@RequestMapping('/admin/event')
class EventAdminController extends BaseController {

    final Right EMPTY = [:] as Right

    @Autowired EventApiService eventApiService

    @RequestMapping(value = '', method = RequestMethod.POST)
    def create(@RequestBody EventCommand cmd, HttpServletResponse response) {
        renderWithResponse response, bind(cmd.validate())
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.PUT)
    def update(@PathVariable Long id, @RequestBody EventCommand cmd, HttpServletResponse response) {
        return [description: ("EVENT SHOW ${id}" as String)]
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.DELETE)
    def delete(@PathVariable Long id, HttpServletResponse response) {
        return [description: ("EVENT SHOW ${id}" as String)]
    }

}