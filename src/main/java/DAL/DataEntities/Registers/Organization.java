package DAL.DataEntities.Registers;

import DAL.DataEntities.Dictionaries.OrgType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REG_ORGANIZATIONS")
public class Organization {
    @Id
    @GeneratedValue
    @Column(name = "ORG_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name="ORG_TYPE", nullable = false)
    private OrgType type;

    @Column(name = "ORG_NAME", nullable = false, unique = true, length = 200)
    private String name;

    @JoinColumn(name = "ORG_ID")
    private List<Location> locations;
}
