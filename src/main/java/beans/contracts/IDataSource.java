package beans.contracts;

import API.DTO.DeviceDTO;

import javax.ejb.Local;
import java.sql.Date;
import java.util.List;

@Local
public interface IDataSource {
    void createDevice(String vendor, String model, Date date);
    void updateDevice(int id, String vendor, String model, Date date);
    void updateDevice(DeviceDTO device);
    void deleteDevice(int id);
    void deleteDevice(DeviceDTO device);
    DeviceDTO getDeviceById(int id);
    List<DeviceDTO> getAll();
}
