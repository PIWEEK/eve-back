package eve.persistence

import eve.core.User

class UserInMemoryRepository implements UserRepository
    extends InMemoryRepository<User> {
}
