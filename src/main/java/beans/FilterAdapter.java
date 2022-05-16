package beans;

import API.DTO.DeviceDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import beans.contracts.IDataSource;
import beans.contracts.IFilterAdapter;

@Stateless
public class FilterAdapter implements IFilterAdapter {
    @EJB
    IDataSource dataSource;

    @Override
    public List<DeviceDTO> filter(HttpServletRequest request) {
        String vendor = Objects.toString(request.getParameter("vendor"), "").trim();
        String model = Objects.toString(request.getParameter("model"), "").trim();
        String dateFrom = Objects.toString(request.getParameter("dateFrom"), "").trim();
        String dateTo = Objects.toString(request.getParameter("dateTo"), "").trim();

        List<DeviceDTO> tmp = new LinkedList<>();
        List<DeviceDTO> deviceList = dataSource.getAll();
        for (DeviceDTO d : deviceList) {
            if (!vendor.isEmpty() && !d.getVendor().contains(vendor)) {
                continue;
            }
            if (!model.isEmpty() && !d.getModel().contains(model)) {
                continue;
            }

            if (!dateFrom.isEmpty() && !d.getDate().after(Date.valueOf(dateFrom))) {
                continue;
            }

            if (!dateTo.isEmpty() && !d.getDate().before(Date.valueOf(dateTo))) {
                continue;
            }

            tmp.add(d);
        }

        if (!vendor.isEmpty() || !model.isEmpty() || !dateFrom.isEmpty() || !dateTo.isEmpty()) {
            deviceList = new ArrayList<>(tmp);
        }

        return deviceList;
    }
}
