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

import eve.api.commands.AuthCommand

@RestController
@RequestMapping('/auth')
class AuthController extends BaseController {

    @Autowired AuthService authService

    @RequestMapping(value = '', method = RequestMethod.POST)
    def list(@RequestBody AuthCommand cmd, HttpServletResponse response) {
        Right right = cmd.asMap()

        renderWithResponse response, bind(right,
                                          authService.&authenticate,
                                          authService.&createToken)
    }

}