package beans;

import API.DTO.DeviceDTO;
import beans.contracts.IDataSource;

import javax.ejb.Stateful;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Stateful
public class DataSource implements IDataSource {
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

    @Override
    public void createDevice(String vendor, String model, Date date) {
        int new_id = deviceList
                        .stream()
                        .mapToInt(DeviceDTO::getId)
                        .max()
                        .orElseThrow(NoSuchElementException::new) + 1;
        deviceList.add(new DeviceDTO(new_id, vendor, model, date));
    }

    @Override
    public void updateDevice(int id, String vendor, String model, Date date) {
        for(DeviceDTO d: deviceList){
            if (d.getId() == id){
                d.setVendor(vendor);
                d.setModel(model);
                d.setDate(date);
                return;
            }
        }
    }

    @Override
    public void updateDevice(DeviceDTO device) {
        updateDevice(device.getId(), device.getVendor(), device.getModel(), device.getDate());
    }

    @Override
    public void deleteDevice(int id) {
        for (int i = 0; i< deviceList.size(); i++){
            DeviceDTO device = deviceList.get(i);
            if (device.getId() == id){
                deviceList.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteDevice(DeviceDTO device) {
        deleteDevice(device.getId());
    }

    @Override
    public DeviceDTO getDeviceById(int id) {
        for (DeviceDTO d: deviceList){
            if (d.getId() == id){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<DeviceDTO> getAll(){
        return deviceList;
    }
}
