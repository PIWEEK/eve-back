package eve.api.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class EventController extends BaseController {

    @RequestMapping('/event')
    public eventList() {
        return 'hola eventos'
    }

}