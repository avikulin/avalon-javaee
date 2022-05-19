package DAL.Utils.Filter;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

class ResultDto{
    private String code;
    private String modelCode;
    private int numPorts;
    private String organization;
    private String location;
    private String ip;

    public ResultDto(String code, String modelCode, int numPorts, String organization, String location, String ip) {
        this.code = code;
        this.modelCode = modelCode;
        this.numPorts = numPorts;
        this.organization = organization;
        this.location = location;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "code='" + code + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", numPorts=" + numPorts +
                ", organization='" + organization + '\'' +
                ", location='" + location + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}

public class debug_runner_query_data {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab1");
        EntityManager em = emf.createEntityManager();
        List<ResultDto> res = em.createQuery(
                                            "select new ru.avalon.java.DAL.Utils.Filter.ResultDTO(" +
                                                    "eu.code, " +
                                                    "eu.model.modelCode, " +
                                                    "eu.model.numPoEPorts, " +
                                                    "eu.location.organization, " +
                                                    "eu.location.locName, " +
                                                    "eu.ipAddress) " +
                                                "from Equipment eu").getResultList();

        for(ResultDto dto: res){
            System.out.println(dto);
        }
    }



}
