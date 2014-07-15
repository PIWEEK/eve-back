package eve.core

class Speaker {

    Long id
    String name
    String twitter
    String bio
    String photo

    Map asMap() {
        [
            id: id,
            name: name,
            twitter: twitter,
            bio: bio,
            photo: photo
        ]
    }
}
