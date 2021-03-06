package eve.api.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import eve.auth.StatelessAuth
import eve.core.User

import eve.api.either.Either
import eve.api.either.Left
import eve.api.either.Right

@Service
class AuthService {

    // To be externalized
    String secret = 'secret'
    StatelessAuth statelessAuth

    AuthService() {
        this.statelessAuth = new StatelessAuth(this.secret)
    }

    Either validateToken(Map data) {
        Map tokenData = this.statelessAuth.validateToken(data.token)
        if (tokenData) {
            return (data + [user: tokenData] + [code: 200]) as Right
        } else {
            return [code: 401, error: 'Invalid token'] as Left
        }
    }

    Either createToken(Map data) {
        Map tokenData = [username: data.username, id: data.id]
        String token = this.statelessAuth.generateToken(tokenData)

        return [token: token, code: 200] as Right
    }

    Either authenticate(Map data) {
        //User user = userRepository.findUserByName()
        //String passwordEncoded = ...
        // if (user.password == passwordEncoded) {
        //     return [username: user.username, user_id: user.id, code: 200] as Right
        // } else {
        //     return [code: 401, error: 'Invalid credentials'] as Left
        // }
        if (data.username) {
            return [username: data.username, id: 1, code: 200] as Right
        } else {
            return [code: 401, error: 'Invalid credentials'] as Left
        }
    }

}