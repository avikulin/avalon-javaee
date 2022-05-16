package DAL.DataEntities.Dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DICT_ORGANIZATION_TYPES")
public class OrgType {
    @Id
    @Column(name = "TYPE_ID", length = 5)
    private String type_id;

    @Column(name = "TYPE_DESCRIPTION", nullable = false, length = 200)
    private String description;
}
