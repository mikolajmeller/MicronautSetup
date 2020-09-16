
package micronautsetup.testapp.auth;

import io.micronaut.security.authentication.UsernamePasswordCredentials;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;

import javax.inject.Singleton;

import static micronautsetup.jooq.generated.test.Tables.USER;

@Singleton
@RequiredArgsConstructor
public class AuthStorage {
    private final DSLContext context;

//    public boolean checkCredentials(UsernamePasswordCredentials credentials) {
//        context.select()
//                .from(USER)
//                .where(USER.NAME.eq(credentials.getUsername()))
//                .and(USER)
//    }
}