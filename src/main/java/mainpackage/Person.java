/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author denis
 */
public class Person {
    private String login;
    private String password;
    private String sessionId;
    public static List<Person> personList;
    
    static {
        personList = new ArrayList<>();
        personList.add(new Person("Boby", "123456"));
        personList.add(new Person("Ivan", "654321"));
        personList.add(new Person("admin", "zvfqrf"));
    }
    
    public static boolean checkSessionId(String sessionId){
        for(Person p : Person.personList){
            if(Objects.equals(p.getSessionId(), sessionId)){
                return true;
            }
        }
        return false;
    }

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
