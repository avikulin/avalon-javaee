package beans.contracts;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface ICheckLogin {
    boolean checkParameters(HttpServletRequest request);
}
