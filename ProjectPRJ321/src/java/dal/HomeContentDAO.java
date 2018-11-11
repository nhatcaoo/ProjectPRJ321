/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import entity.HomeContent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class HomeContentDAO {

    DBContext dbcon;
    Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public HomeContentDAO() {
     
    }

    public HomeContent getHomeContent() throws Exception{
        HomeContent home = new HomeContent();
        String sql = "select * from HomeContent";
        try {
            dbcon = new DBContext();
            conn = dbcon.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                //String image = rs.getString(4);
                String image = dbcon.getUrl() + "/" + rs.getString(4);
                home = new HomeContent(id, title, content, image);
            }
            dbcon.close(conn, pre, rs);
        } catch (Exception ex) {
            dbcon.close(conn, pre, rs);
            Logger.getLogger(HomeContentDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return home;
    }

}
