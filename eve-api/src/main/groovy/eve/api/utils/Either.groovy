package eve.api.utils

class Either {
    EitherStatus status = EitherStatus.RIGHT
    Map data
 
    String toString() {
        return "[${this.status}] > ${this.data}"
    }

    Boolean isLeft() {
        either.status == EitherStatus.LEFT
    }

    Either fmap(Either either, Closure... methods) {
        for (Closure method : methods) {
            if (either.isLeft()) {
                break
            } else {
                either = method.call(either)
            }
        }
        return either
    }
}