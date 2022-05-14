package DAL;

import java.sql.Date;
import java.util.*;

public class DeviceDTO {
    int id;
    String vendor;
    String model;
    Date date;

    static public List<DeviceDTO> deviceList;

    static {
        deviceList = new ArrayList<>();
        deviceList.add(new DeviceDTO(1, "Smsung", "A50", Date.valueOf("2018-01-15")));
        deviceList.add(new DeviceDTO(2, "Lenovo", "SE56", Date.valueOf("2016-02-25")));
        deviceList.add(new DeviceDTO(3, "HP", "Link65", Date.valueOf("2015-12-12")));
        deviceList.add(new DeviceDTO(4, "Xiaomi", "XIOH", Date.valueOf("2011-11-18")));
        deviceList.add(new DeviceDTO(5, "Asus", "SM50", Date.valueOf("2019-07-28")));
        deviceList.add(new DeviceDTO(6, "WD", "WD40", Date.valueOf("2018-12-12")));
        deviceList.add(new DeviceDTO(7, "Samsung", "A56", Date.valueOf("2017-11-03")));
        deviceList.add(new DeviceDTO(8, "Lenovo", "LN-150", Date.valueOf("2019-08-11")));
        deviceList.add(new DeviceDTO(9, "Xiaomi", "XI100", Date.valueOf("2020-03-21")));
        deviceList.add(new DeviceDTO(10, "WD", "WD50", Date.valueOf("2020-04-17")));
    }

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

    public static void addDevice(String vendor, String model, Date date) {
        Integer id = deviceList
                        .stream()
                        .mapToInt(i -> i.getId())
                        .max()
                        .orElseThrow(NoSuchElementException::new) + 1;
        deviceList.add(new DeviceDTO(id, vendor, model, date));
    }
}
