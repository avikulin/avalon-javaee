package beans;

import beans.contracts.ICheckLogin;
import mainpackage.Person;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class CheckLogin implements ICheckLogin {
    @Override
    public boolean checkParameters(HttpServletRequest request){
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login.isEmpty()) {
            request.setAttribute("msgError", "Не валидный логин");
            return false;
        }
        if(password.isEmpty()) {
            request.setAttribute("msgError", "Не валидный пароль");
            return false;
        }
        for(Person p : Person.personList){
            if(p.getLogin().equals(login)){
                if(p.getPassword().equals(password)){
                    p.setSessionId(request.getSession().getId());
                    request.setAttribute("sessionId", p.getSessionId());
                    return true;
                }
            }
        }
        request.setAttribute("msgError", "Логин или пароль не найдены");
        return false;
    }
}
