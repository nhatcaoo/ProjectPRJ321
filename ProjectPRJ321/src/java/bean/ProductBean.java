/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;



import Model.CafeProductModel;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu bach
 */
public class ProductBean {

    String pid;
   
    
    
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<CafeProductModel> selectAllProduct() throws Exception {
        List<CafeProductModel> ls = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String query = "select * from CafeProduct";
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
            int pid = rs.getInt(1);
            String pname = rs.getString(2);
            String price = rs.getString(3);
             String shortDescription = rs.getString(4);
              String fullDescription = rs.getString(5);
            String imageName = rs.getString(6);
           
            int catalogueID = rs.getInt(7);
            ls.add(new CafeProductModel(pid, pname, price, shortDescription,fullDescription, price, catalogueID));

        }
        return ls;
    }

    public void deleteProduct() throws Exception {
        Connection conn = new DBContext().getConnection();
        String query = "delete from CafeProduct where productID = " + pid;
        conn.prepareStatement(query).executeUpdate();
        conn.close();
    }

    public void UpdateProduct(int pid, String pname, String price, String imgName, int catalogueID, String shortDesc,String fullDesc) throws Exception {
        Connection conn = new DBContext().getConnection();
        String query = "update CafeProduct\n"
                + "set productName='" + pname + "', productPrice= " + price + ", productImage='" + imgName + "',productShortDescription='" + shortDesc +  "',productFullDescription='" + fullDesc +"', catalogueID= " + catalogueID + "\n"
                + "where productID= " + pid;
        conn.prepareStatement(query).executeUpdate();
        conn.close();
    }
    
    public void InsertProduct(int pid, String pname, String price, String imgName, int catalogueID, String shortDesc,String fullDesc) throws Exception{
         Connection conn = new DBContext().getConnection();
         String query="insert into CafeProduct values(?,?,?,?,?,?,?)";
        PreparedStatement pr = conn.prepareStatement(query);
        pr.setInt(1, pid);
        pr.setString(2, pname);
        pr.setString(3, price);
        pr.setString(4, shortDesc);
        pr.setString(5, fullDesc);
        pr.setString(6, imgName);
        pr.setInt(7, catalogueID);
        pr.executeUpdate();
        conn.close();
    }
    
   
}
