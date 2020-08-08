package micronautsetup.testapp.auth;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class AuthStorage {
    private final DSLContext context;


}
