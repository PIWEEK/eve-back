package eve.api.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import eve.auth.StatelessAuth

@Service
class AuthService {

    // To be externalized
    String secret = 'secret'
    StatelessAuth statelessAuth

    AuthService() {
        this.statelessAuth = new StatelessAuth(this.secret)
    }

    String generateToken(Map data) {
        return this.statelessAuth.generateToken(data)
    }

    Map validateToken(String token) {
        return this.statelessAuth.validateToken(token)
    }

}