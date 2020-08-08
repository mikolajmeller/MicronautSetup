package micronautsetup.testapp.user;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class UserAlreadyExist extends HttpStatusException {
    public UserAlreadyExist(String username) {
        super(HttpStatus.CONFLICT, String.format("User with name: %s already exists", username));
    }
}
