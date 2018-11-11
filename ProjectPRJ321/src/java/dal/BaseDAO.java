/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.BaseModel;

/**
 *
 * @author Quoc Anh
 */
public abstract class BaseDAO<T extends BaseModel> {
    protected Connection connection;
    public BaseDAO()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user="sa";
            String pass = "matkhaumoi1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=sentai";
            connection =  DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public abstract ArrayList<T> getAll();
    public abstract T get(int id);
    public abstract void insert(T model);
    public abstract void update(T model);
    public abstract void dele(int id);
    public abstract ArrayList<T> SelectByDeID(int id);
    
}
