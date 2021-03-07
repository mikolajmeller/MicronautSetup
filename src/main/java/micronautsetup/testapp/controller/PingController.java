package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
@Produces(MediaType.APPLICATION_JSON)
public class PingController {
    @Get
    public HttpResponse<String> ping() {
        return HttpResponse.ok("{\"value\": \"Ping pong\"}");
    }
}
