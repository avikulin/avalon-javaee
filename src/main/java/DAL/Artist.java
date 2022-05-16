package DAL;

import org.eclipse.persistence.platform.database.PostgreSQLPlatform;
import org.postgresql.ds.PGSimpleDataSource;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String email;
    @Column(length = 2000)
    private String bio;
    private LocalDate dateOfBirth;

    void test(){
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{""});
        ds.setDatabaseName("");
        ds.setUser("");
        ds.setPassword("");

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.nonJtaDataSource", ds);

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA", props);
    }
}
