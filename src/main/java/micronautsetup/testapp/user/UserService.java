package micronautsetup.testapp.user;

import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class UserService {
    private final UserStorage storage;

    public List<User> getAllUsers() {
        return storage.getAll();
    }

    public User getUser(Integer id) {
        return storage.get(id)
                .orElseThrow(() -> new UserNotExist(id));
    }

    public Optional<User> getUser(String name) {
        return storage.get(name);
    }

    public User create(String name) {
        return storage.create(name);
    }

    public void delete(Integer id) {
        storage.delete(id);
    }
}
