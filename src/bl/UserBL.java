package bl;

import dao.UserDAO;
import exception.PasswordFalseException;
import exception.UserExistedException;
import exception.UserNoneException;
import bo.InterView;
import bo.User;

import java.util.List;

public class UserBL {
    UserDAO userDao = new UserDAO();
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
        List<User> user = userDao.findUser(newUser);
        return user;
    }

    public void register(User newUser) throws UserExistedException {

        List<User> user = userDao.findUser(newUser);
        if (user != null && !user.isEmpty()) {
            throw new UserExistedException();
        } else {
            userDao.addUser(newUser);
        }
    }

    public void del(String username) {
        userDao.del(username);
    }

    public int findCount(User user) {
        return userDao.findCount(user);
    }

    public List<User> find(User newUser, int pageSize, int pageNumber) {
        List<User> user = userDao.findUser(newUser,  pageSize,  pageNumber);
        return user;
    }
}
