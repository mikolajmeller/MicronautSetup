package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.RequiredArgsConstructor;
import micronautsetup.testapp.user.User;
import micronautsetup.testapp.user.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller(consumes = MediaType.ALL, value = "/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;


	@Secured(SecurityRule.IS_AUTHENTICATED)
	@Get("/")
	public HttpResponse<String> get(Principal principal) {
		return HttpResponse.ok(principal.getName());
	}

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable @Valid Integer id) {
        return HttpResponse.ok(service.getUser(id));
    }

	@Post()
	public HttpResponse<User> createUser(@Body("name") String name) {
		return HttpResponse.ok(service.create(name));
	}
}
