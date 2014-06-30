package common;

import bo.User;

import javax.servlet.http.HttpSession;


public class SystemContext {
    public static void setUser(HttpSession session,User user){
           session.setAttribute("LOGIN_USER",user);
    }
    public static User getUser(HttpSession session){
        return (User)session.getAttribute("LOGIN_USER");
    }
}
