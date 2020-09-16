/*
 * This file is generated by jOOQ.
 */
package micronautsetup.jooq.generated.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import micronautsetup.jooq.generated.test.tables.Auth;
import micronautsetup.jooq.generated.test.tables.User;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Test extends SchemaImpl {

    private static final long serialVersionUID = -1420233931;

    /**
     * The reference instance of <code>test</code>
     */
    public static final Test TEST = new Test();

    /**
     * The table <code>test.auth</code>.
     */
    public final Auth AUTH = micronautsetup.jooq.generated.test.tables.Auth.AUTH;

    /**
     * The table <code>test.user</code>.
     */
    public final User USER = micronautsetup.jooq.generated.test.tables.User.USER;

    /**
     * No further instances allowed
     */
    private Test() {
        super("test", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Auth.AUTH,
            User.USER);
    }
}
