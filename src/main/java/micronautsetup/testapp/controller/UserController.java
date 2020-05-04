package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import micronautsetup.testapp.model.User;

@Controller(produces = MediaType.APPLICATION_JSON)
public class UserController {

	@Get("/user/{userId}")
	public HttpResponse<User> getUser(@PathVariable Integer userId) {
		return HttpResponse.ok(new User(userId, "name"));
	}
}
