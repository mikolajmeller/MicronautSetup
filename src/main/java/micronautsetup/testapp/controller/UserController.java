package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import micronautsetup.testapp.user.User;
import micronautsetup.testapp.user.UserService;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Controller(value = "/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable Integer id) {
        return HttpResponse.ok(service.getUser(id));
    }

	@Get
	public HttpResponse<Optional<User>> getUserByName(@QueryValue @NotEmpty String name) {
		return HttpResponse.ok(service.getUser(name));
	}

	@Get("/all")
	public HttpResponse<List<User>> getAllUsers() {
		return HttpResponse.ok(service.getAllUsers());
	}

	@Post
	public HttpResponse<User> createUser(@Body("name") String name) {
		return HttpResponse.ok(service.create(name));
	}

	@Delete("/{id}")
	public HttpResponse<Void> deleteUser(@PathVariable Integer id) {
    	service.delete(id);
    	return HttpResponse.noContent();
	}

}
