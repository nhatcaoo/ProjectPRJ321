/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Model.CafeProductModel;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author This PC
 */
public class ProductDAO {
     DBContext dbcon;
    Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public ProductDAO() {

    }

    public Vector<CafeProductModel> getCake(int i) throws Exception {
        Vector<CafeProductModel> vec = new Vector();
        String sql = "  WITH TblCte as (SELECT  *,ROW_NUMBER() OVER (ORDER BY productID) RowNumber FROM CafeProduct)\n" +
"                SELECT  * FROM TblCte WHERE RowNumber between ? and ?";
        try {
            dbcon = new DBContext();
            conn = dbcon.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, i);
            pre.setInt(2, (i + 2));
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
               
                String shortDescription = rs.getString(4);
                String fullDescription = rs.getString(6);
                //String urlImage = rs.getString(5); thay bằng dòng dưới
                String urlImage = "images" + "/" + rs.getString(7);
                vec.add(new CafeProductModel(id, price, price, shortDescription, fullDescription, urlImage));
            }
          
        } catch (SQLException ex) {
           
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return vec;

    }

 

    public CafeProductModel getCakeDetail(int i) throws Exception {
        CafeProductModel vec = new CafeProductModel();
        String sql = "select * from CafeProduct a  left join Catalogue b on a.catalogueID=b.catalogueID where productID=?";
        try {
            dbcon = new DBContext();
            conn = dbcon.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, i);
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                 String price = rs.getString(3);
                String short_description = rs.getString(4);
                String full_description = rs.getString(5);               
                  String Catalogue = rs.getString("catalogueName");
                //String urlImage = rs.getString(5);
                String urlImage = "images" + "/" + rs.getString("productImage");
                vec = new CafeProductModel(id, price, price, short_description, full_description, Catalogue, urlImage);
            }
           
        } catch (SQLException ex) {

            Logger.getLogger(CafeProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return vec;

    }

    public int getNumberCake() throws Exception {
        int n = 0;
        String sql = "select * from CafeProduct";
        try {
            dbcon = new DBContext();
            conn = dbcon.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                n++;
            }
            
        } catch (SQLException ex) {
          
            Logger.getLogger(CafeProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return n;

    }
}
