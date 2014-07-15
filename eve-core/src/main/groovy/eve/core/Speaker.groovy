package eve.core

class Speaker {
    String name
    String twitter
    String bio
    String photo

    Map asMap() {
        [
            name: name,
            twitter: twitter,
            bio: bio,
            photo: photo
        ]
    }
}
