package DAL.DataEntities.Registers;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REG_ORG_LOCATIONS", uniqueConstraints = {
        @UniqueConstraint(name = "ORG_LOCATIONS_UC",columnNames = {"ORG_ID", "LOC_NAME"})
})
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "LOC_ID")
    private Long id;

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID")
    private Organization organization;

    @Column(name = "LOC_NAME", nullable = false, length = 50)
    private String locName;

    @Column(name = "LOC_ADDRESS", nullable = false, length = 250)
    private String locAddress;

    @ManyToMany(mappedBy = "locations")
    private List<Contact> contacts;
}
