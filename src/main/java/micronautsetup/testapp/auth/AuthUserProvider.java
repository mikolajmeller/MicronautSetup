package micronautsetup.testapp.auth;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;

import javax.annotation.Nullable;
import java.util.List;

@RequiredArgsConstructor
public class AuthUserProvider implements AuthenticationProvider {
    private final AuthStorage storage;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            String username = authenticationRequest.getIdentity().toString();
            String password = authenticationRequest.getSecret().toString();

            if (authenticationRequest.getIdentity().equals("sherlock") && authenticationRequest.getSecret().equals("password")) {
            emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), List.of()));
            emitter.onComplete();
        } else {
            emitter.onError(new AuthenticationException(new AuthenticationFailed()));
        }
        }, BackpressureStrategy.ERROR);
    }
}
