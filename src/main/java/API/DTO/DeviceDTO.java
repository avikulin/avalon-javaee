package API.DTO;

import java.sql.Date;
import java.util.*;

public class DeviceDTO {
    int id;
    String vendor;
    String model;
    Date date;

    public DeviceDTO(int id, String vendor, String model, Date date) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getDate() {
        return date;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
