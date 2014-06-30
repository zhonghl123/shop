package bl;

import dao.UserDAO;
import exception.PasswordFalseException;
import exception.UserExistedException;
import exception.UserNoneException;
import bo.InterView;
import bo.User;

import java.util.List;

public class UserBL {

    public void verify(User formUser) throws UserNoneException, PasswordFalseException {
        UserDAO userDAO = new UserDAO();
        List<User> dbUser = userDAO.findUser(formUser);
        if (dbUser != null && dbUser.size() == 1
                && dbUser.get(0).getPassword().equals(formUser.getPassword())
                && dbUser.get(0).getUsername().equals(formUser.getUsername())) {

        } else if (dbUser != null && dbUser.size() == 1 && dbUser.get(0).getUsername().equals(formUser.getUsername()) && !dbUser.get(0).getPassword().equals(formUser.getPassword())) {
            throw new PasswordFalseException();
        } else {
            throw new UserNoneException();
        }

    }

    public List<User> find(User newUser) throws UserExistedException {
        UserDAO userDao = new UserDAO();
        List<User> user = userDao.findUser(newUser);
        return user;
    }

    public void register(User newUser) throws UserExistedException {
        UserDAO userDao = new UserDAO();
        List<User> user = userDao.findUser(newUser);
        if (user != null && !user.isEmpty()) {
            throw new UserExistedException();
        } else {
            userDao.addUser(newUser);
        }
    }

    public void resetPwd(User user) throws UserNoneException {
        UserDAO userDAO = new UserDAO();
        User dbUser = userDAO.findUser2(user);
        if (dbUser != null && dbUser.getIdname().equals(user.getIdname())) {
            userDAO.resetPwd(user);
        } else {
            throw new UserNoneException();

        }
    }

    public void del(String username) {
        UserDAO userDAO = new UserDAO();
        userDAO.del(username);
    }

    public int findCount(User user) {
        UserDAO userDAO = new UserDAO();
        return userDAO.findCount(user);
    }

    public List<User> find(User newUser, int pageSize, int pageNumber) {
        UserDAO userDao = new UserDAO();
        List<User> user = userDao.findUser(newUser,  pageSize,  pageNumber);
        return user;
    }
}
