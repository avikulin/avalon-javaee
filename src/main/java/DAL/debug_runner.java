package DAL;

import DAL.DataEntities.Dictionaries.*;
import DAL.DataEntities.Enums.OsiLayer;
import DAL.DataEntities.Registers.Location;
import DAL.DataEntities.Registers.Organization;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class debug_runner {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab1");
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Country country = new Country();
        country.setCode("US");
        country.setShortName("United States");
        country.setFullName("United States of America");

        OrgType orgType = new OrgType();
        orgType.setType_id("LTD");
        orgType.setDescription("Limited liability partnership");

        Sex sex = new Sex();
        sex.setId("M");
        sex.setName("Male");

        Organization organization = new Organization();
        organization.setName("Рога и копыта");
        organization.setType(orgType);


        Vendor vendor = new Vendor();
        vendor.setName("Zyxel Corp.");
        vendor.setCountryOfOrigin(country);
        vendor.setWebSite("https://www.zyxel.com/ru/ru/homepage.shtml");

        Model model1 = new Model();
        model1.setModelCode("XGS3700-24");
        model1.setLayerNum(OsiLayer.LEVEL3);
        model1.setModelDescription("24-портовый гигабитный L3 коммутатор с 10G аплинком");
        model1.setVendor(vendor);
        model1.setNum100MbpsPorts(24);
        model1.setNum10GbpsPorts(4);
        model1.setNumPoEPorts(0);
        model1.setImageUrl("https://www.zyxel.com/library/assets/products/xgs3700/img_xgs3700-24_p_1000.jpg");

        Model model2 = new Model();
        model2.setModelCode("XGS3700-24HP");
        model2.setLayerNum(OsiLayer.LEVEL3);
        model2.setModelDescription("24-портовый гигабитный L3 PoE коммутатор с 10G аплинком");
        model2.setVendor(vendor);
        model2.setNum100MbpsPorts(24);
        model2.setNum10GbpsPorts(4);
        model2.setNumPoEPorts(24);
        model2.setImageUrl("https://www.zyxel.com/library/assets/products/xgs3700/img_xgs3700-24hp_p_1000.jpg");

        Model model3 = new Model();
        model3.setModelCode("XGS3700-48");
        model3.setLayerNum(OsiLayer.LEVEL3);
        model3.setModelDescription("48-портовый гигабитный L3 коммутатор с 10G аплинком");
        model3.setVendor(vendor);
        model3.setNum100MbpsPorts(48);
        model3.setNum10GbpsPorts(4);
        model3.setNumPoEPorts(0);
        model3.setImageUrl("https://www.zyxel.com/library/assets/products/xgs3700/img_xgs3700-48_p_1000.jpg");

        Model model4 = new Model();
        model4.setModelCode("XGS3700-48HP");
        model4.setLayerNum(OsiLayer.LEVEL3);
        model4.setModelDescription("48-портовый гигабитный L3 PoE коммутатор с 10G аплинком");
        model4.setVendor(vendor);
        model4.setNum100MbpsPorts(48);
        model4.setNum10GbpsPorts(4);
        model4.setNumPoEPorts(48);
        model4.setImageUrl("https://www.zyxel.com/library/assets/products/xgs3700/img_xgs3700-48hp_p_1000.jpg");

        
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
