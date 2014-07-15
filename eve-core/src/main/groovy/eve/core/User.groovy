package eve.core

class User {
    Long id
    String name
    String password

    Map asMap() {
        [
            id: id,
            name: name,
            password: password
        ]
    }
}
