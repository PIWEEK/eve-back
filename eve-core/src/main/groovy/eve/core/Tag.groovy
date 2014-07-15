package eve.core

class Tag {

    Long id
    String name

    Map asMap() {
        [
            id: id,
            name: name
        ]
    }
}
