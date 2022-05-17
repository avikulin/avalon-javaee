package DAL.DataEntities.Dictionaries;

import javax.persistence.*;

@Entity
@Table(name = "DICT_VENDORS",
       uniqueConstraints = {@UniqueConstraint(name = "NAME_COUNTRY_UC", columnNames = {"VENDOR_NAME", "COUNTRY_ID"})})
public class Vendor {
    @Id
    @GeneratedValue
    @Column(name = "VENDOR_ID")
    private Long id;

    @Column(name = "VENDOR_NAME", nullable = false, length = 200)
    private String name;

    @OneToOne
    @JoinColumn(name = "COUNTRY_ID",  nullable = false)
    private Country countryOfOrigin;

    @Column(name = "WEB_SITE", nullable = false, length = 200)
    private String webSite;
}
