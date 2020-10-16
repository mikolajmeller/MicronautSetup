package micronautsetup.testapp.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class PingController {
    @Get
    public HttpResponse<String> ping() {
        return HttpResponse.ok("ping");
    }
}
