package eve.api.either

abstract class Either extends LinkedHashMap {

    Boolean isLeft() {
        return this instanceof Left
    }

    Boolean isRight() {
        return this instanceof Right
    }

    static Either bind(Either either, Closure... methods) {
        for (Closure method : methods) {
            if (either.isLeft()) {
                break
            } else {
                either = method.call(either.data)
            }
        }
        return either
    }

    Map getData() {
        return this.findAll { k, v -> k != 'code' }
    }

}