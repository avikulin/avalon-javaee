package DAL.DataEntities.Dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DICT_SEX")
public class Sex {
    @Id
    @Column(name = "SEX_ID", length = 1)
    private String id;

    @Column(name = "SEX_DESCRIPTION", nullable = false, length = 100)
    private String name;
}
