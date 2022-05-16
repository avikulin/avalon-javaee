package beans.contracts;

import API.DTO.DeviceDTO;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Local
public interface IFilterAdapter {
    List<DeviceDTO> filter(HttpServletRequest request);
}
