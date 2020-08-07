package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import micronautsetup.testapp.user.User;
import micronautsetup.testapp.user.UserService;

import javax.validation.Valid;

@Controller(consumes = MediaType.ALL, value = "/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable @Valid Integer id) {
        return HttpResponse.ok(service.getUser(id));
    }

	@Post()
	public HttpResponse<User> createUser(@Body("name") String name) {
		return HttpResponse.ok(service.create(name));
	}
}
