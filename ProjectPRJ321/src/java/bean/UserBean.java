/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import Model.UserModel;
import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author This PC
 */
public class UserBean {

    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserModel> selectAll() throws Exception {

        List<UserModel> users = new ArrayList<>();

        String sql = "  Select a.username,a.password,c.groupID from USERS a\n"
                + "  left join USER_Group b on a.username=b.username\n"
                + "  left join USER_Group c on b.groupID=c.groupID";
        Connection connection = new DBContext().getConnection();
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
           
            String name = rs.getString(1);
            String password = rs.getString(2);
            String url = rs.getString(3);
            users.add(new UserModel( name, password, url));

        }
        rs.close();
        connection.close();
        return users;
    }

    public void deleteUser() throws Exception {
        Connection conn = new DBContext().getConnection();
        String query = "Delete USERS where userName=" + this.userName;
        conn.prepareStatement(query).executeUpdate();
        conn.close();
    }

}
