/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.FeatureModel;
import Model.UserModel;

/**
 *
 * @author Quoc Anh
 */
public class UserDAO extends BaseDAO<UserModel>{

    @Override
    public ArrayList<UserModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(UserModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dele(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserModel> SelectByDeID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<UserModel> SelectUsers(String username) throws SQLException{
        String sql= "SELECT * FROM USERS u JOIN USER_Group ug\n" +
                    "ON u.username = ug.username JOIN USERGROUP g\n" +
                    "ON ug.groupID = g.groupID JOIN Role r\n" +
                    "ON g.groupID = r.groupID JOIN Feature f\n" +
                    "ON r.featureID = f.featureID\n" +
                    "WHERE u.username like '%' + ? + '%'";
        ArrayList<UserModel> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            UserModel user = new UserModel();
            user.setUseName(rs.getString("username"));
            user.setPassWd(rs.getString("password"));
            user.setUrl(rs.getString("URL"));
            users.add(user);
        }
        return users; 
    }
     public UserModel Select(String username) throws SQLException{
         String sql= "SELECT * FROM USERS u \n" +                   
                    "WHERE u.username like '%' + ? + '%'";      
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        UserModel user = null;
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            user = new UserModel();
            user.setUseName(rs.getString("username"));
            user.setPassWd(rs.getString("password"));
        }
        return user;
     }
}
