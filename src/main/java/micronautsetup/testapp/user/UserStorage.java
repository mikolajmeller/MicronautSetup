package micronautsetup.testapp.user;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;

import javax.inject.Singleton;

import java.util.List;
import java.util.Optional;

import static micronautsetup.jooq.generated.test.Tables.*;

@Singleton
@RequiredArgsConstructor
public class UserStorage {
    private final DSLContext context;

    public List<User> getAll() {
        return context.select()
                .from(USER)
                .fetchInto(User.class);
    }

    public Optional<User> get(Integer id) {
        return context.select()
                .from(USER)
                .where(USER.ID.eq(UInteger.valueOf(id)))
                .fetchOptionalInto(User.class);
    }

    public void delete(Integer id) {
        int count = context.delete(USER)
                .where(USER.ID.eq(UInteger.valueOf(id)))
                .execute();
        if (count == 0) {
            throw new UserNotExist(id);
        }
    }

    public Optional<User> get(String name) {
        return context.select()
                .from(USER)
                .where(USER.NAME.eq(name))
                .fetchOptionalInto(User.class);
    }

    public User create(String name) {
        return context.insertInto(USER)
                .set(USER.NAME, name)
                .onConflictDoNothing()
                .returningResult(USER.ID, USER.NAME)
                .fetchOptional()
                .orElseThrow(() -> new UserAlreadyExist(name))
                .map(record -> new User(record.get(USER.ID).intValue(), record.getValue(USER.NAME)));
    }

    public User rename(User user, String newName) {
        return context.update(USER)
                .set(USER.NAME, newName)
                .where(USER.ID.eq(UInteger.valueOf(user.getId())))
                .and(USER.NAME.eq(user.getName()))
                .returningResult()
                .fetchOne()
                .map(record -> new User(record.get(USER.ID).intValue(), record.getValue(USER.NAME)));
    }
}
