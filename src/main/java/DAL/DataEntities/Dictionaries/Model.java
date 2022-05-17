package DAL.DataEntities.Dictionaries;

import DAL.DataEntities.Enums.OsiLayer;

import javax.persistence.*;

@Entity
@Table(name = "DICT_MODELS",
       uniqueConstraints = {@UniqueConstraint(name = "MODEL_VENDOR_UC", columnNames = {"MODEL_CODE","VENDOR_ID"})})
public class Model {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "MODEL_CODE", nullable = false, scale = 100)
    private String modelCode;

    @OneToOne
    @JoinColumn(name = "VENDOR_ID", nullable = false)
    private Vendor vendor;

    @Column(name = "MODEL_DESCRIPTION", nullable = false)
    private String modelDescription;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "LAYER_NUM", nullable = false)
    private OsiLayer layerNum;

    @Column(name = "PORTS_100MBPS")
    private int num100MbpsPorts;

    @Column(name = "PORTS_10GBPS")
    private int num10GbpsPorts;

    @Column(name = "PORTS_POE")
    private int numPoEPorts;

    @Column(name = "IMAGE_URL", nullable = false, length = 200)
    private String imageUrl;

    @Transient
    private int totalNumPorts;
}
