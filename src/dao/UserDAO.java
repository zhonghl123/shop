package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.ConnectionProvider;
import db.SQLTemplate;
import exception.PasswordFalseException;
import bo.Goods;
import bo.User;

public class UserDAO {
    SQLTemplate st = new SQLTemplate();

    public List<User> findUser(User user) {
        List<User> userList = new ArrayList<User>();
        String username = user.getUsername();
        String password = user.getPassword();
        String sql = "select * from p_user";
        ResultSet rs1;
        if ((username != null && !"".equals(username)) && ((password != null && !"".equals(password)))) {
            sql = "select * from p_user where  username = ? and password =?";
            rs1 = st.executeQuery(sql, username, password);
        } else if (username != null && !"".equals(username)) {
            sql = "select * from p_user where  username = ? ";
            rs1 = st.executeQuery(sql, username);
        } else if (password != null && !"".equals(password)) {
            sql = "select * from p_user where  password =?";
            rs1 = st.executeQuery(sql, password);
        } else {
            rs1 = st.executeQuery(sql);
        }
        User newUser = null;

        try {
            while (rs1.next()) {
                String name = rs1.getString(1);
                String word = rs1.getString(2);
                String idNumber = rs1.getString(3);
                userList.add(new User(name, word, idNumber));
            }
            return userList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            st.close();
        }
        return userList;
    }

    public User findUser2(User user) {
        String username = user.getUsername();
        String idName = user.getIdname();
        String sql = "select * from p_user where username = ? and idname = ?";
        User newUser = null;
        ResultSet rs1 = st.executeQuery(sql, username, idName);
        try {
            if (rs1.next()) {
                String name = rs1.getString(1);
                String word = rs1.getString(2);
                String idNumber = rs1.getString(3);
                newUser = new User(name, word, idNumber);
            }
            return newUser;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            st.close();
        }
        return newUser;
    }

    public void addUser(User newUser) {
        String username = newUser.getUsername();
        String password = newUser.getPassword();
        String idname = newUser.getIdname();
        String sql = "insert into p_user(username,password,idname) values (?,?,?)";
        st.executeUpdate(sql, username, password, idname);
        //st.close();
    }

    public void resetPwd(User user) {
        String sql = "UPDATE p_user SET password = ? WHERE idname = ?";
        st.executeUpdate(sql, user.getPassword(), user.getIdname());

    }

    public void del(String id) {
        String sql = "delete from p_user where username=?";
        st.executeUpdate(sql, id);
    }

    public Integer findCount(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String sql = "select count(*) from p_user";
        ResultSet rs1;
        if ((username != null && !"".equals(username)) && ((password != null && !"".equals(password)))) {
            sql = "select count(*) from p_user where  username = ? and password =?";
            rs1 = st.executeQuery(sql, username, password);
        } else if (username != null && !"".equals(username)) {
            sql = "select count(*) from p_user where  username = ? ";
            rs1 = st.executeQuery(sql, username);
        } else if (password != null &&! "".equals(password)) {
            sql = "select count(*) from p_user where  password =?";
            rs1 = st.executeQuery(sql, password);
        } else {
            rs1 = st.executeQuery(sql);
        }
        User newUser = null;

        try {
            while (rs1.next()) {
                return rs1.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            st.close();
        }
        return null;
    }

    public List<User> findUser(User newUser, int pageSize, int pageNumber) {
        List<User> userList = new ArrayList<User>();
        String username = newUser.getUsername();
        String idname = newUser.getIdname();
        int start= pageSize*(pageNumber-1);
        String sql = "select * from p_user limit "+start+","+pageSize;
        ResultSet rs1;
        if ((username != null && !"".equals(username)) && ((idname != null && !"".equals(idname)))) {
            sql = "select * from p_user where  username = ? and idname =? limit "+start+","+pageSize;
            rs1 = st.executeQuery(sql, username, idname);
        } else if (username != null && !"".equals(username)) {
            sql = "select * from p_user where  username = ? limit "+start+","+pageSize;
            rs1 = st.executeQuery(sql, username);
        } else if (idname != null && !"".equals(idname)) {
            sql = "select * from p_user where  idname =? limit "+start+","+pageSize;
            rs1 = st.executeQuery(sql, idname);
        } else {
            rs1 = st.executeQuery(sql);
        }
        User user = null;
        try {
            while (rs1.next()) {
                String name = rs1.getString(1);
                String word = rs1.getString(2);
                String idNumber = rs1.getString(3);
                userList.add(new User(name, word, idNumber));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            st.close();
        }
        return userList;
    }
}
