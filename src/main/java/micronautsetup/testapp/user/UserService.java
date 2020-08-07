package micronautsetup.testapp.user;

import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class UserService {
    private final UserStorage storage;

    public User getUser(Integer id) {
        return storage.get(id)
                .orElseThrow(() -> new UserNotExist(id));
    }

    public User create(String name) {
        return storage.create(name);
    }
}
