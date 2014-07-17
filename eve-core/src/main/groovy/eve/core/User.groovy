package eve.core

class User {

    Long id
    String username
    String password

    Map asMap() {
        [
            id: id,
            username: username,
            password: password
        ]
    }
}
