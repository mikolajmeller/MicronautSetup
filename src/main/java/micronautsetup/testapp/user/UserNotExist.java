package micronautsetup.testapp.user;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class UserNotExist extends HttpStatusException {
    public UserNotExist(Integer userId) {
        super(HttpStatus.NOT_FOUND, String.format("User with ID %d doesn't exist", userId));
    }

    public UserNotExist(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
