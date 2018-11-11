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
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.CafeProductModel;

/**
 *
 * @author sonnt
 */
public class CafeProductDAO extends BaseDAO<CafeProductModel> {

    @Override
    public ArrayList<CafeProductModel> getAll() {
         try {
            String sql = "SELECT [productID]\n" +
                    "      ,[productName]\n" +
                    "      ,[productPrice]\n" +
                    "      ,[productShortDescription]\n" +
                    "      ,[productFullDescription]\n" +
                    "      ,[productImage]\n" +
                    "      ,[catalogueID]\n" +
                    "  FROM [CafeProduct]";
            ArrayList<CafeProductModel> students = new ArrayList
                     <>();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                CafeProductModel cafe = new CafeProductModel();
                cafe.setProductID(rs.getInt("productID") );
                cafe.setProductName(rs.getString("productName") );
                cafe.setProductPrice(rs.getString("productPrice") );
                cafe.setProductPrice(rs.getString("productPrice") );
                cafe.setProductPrice(rs.getString("productPrice") );
                cafe.setDob(rs.getDate("studentdob") );
                cafe.add(student);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CafeProductModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(CafeProductModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CafeProductModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dele(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CafeProductModel> SelectByDeID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public ArrayList<StudentModel> getAll() {
//        try {
//            String sql = "SELECT [studentid]\n" +
//                    "      ,[studentname]\n" +
//                    "      ,[studentgender]\n" +
//                    "      ,[studentdob]\n" +
//                    "  FROM [Students]";
//            ArrayList<StudentModel> students = new ArrayList
//                     <>();
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next())
//            {
//                StudentModel student = new StudentModel();
//                student.setID( rs.getInt("studentid") );
//                student.setName(rs.getString("studentname") );
//                student.setGender(rs.getBoolean("studentgender") );
//                student.setDob(rs.getDate("studentdob") );
//                students.add(student);
//            }
//            return students;
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public StudentModel get(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insert(StudentModel model) {
//        try {
//            String sql = "INSERT INTO [Students]\n" +
//                    "           ([studentid]\n" +
//                    "           ,[studentname]\n" +
//                    "           ,[studentgender]\n" +
//                    "           ,[studentdob])\n" +
//                    "     VALUES\n" +
//                    "           (?\n" +
//                    "           ,?\n" +
//                    "           ,?\n" +
//                    "           ,?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, model.getID());
//            statement.setString(2, model.getName());
//            statement.setBoolean(3, model.isGender());
//            statement.setDate(4, model.getDob());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//
//
//    @Override
//    public void dele(int id) {
//        try {
//            String sql = "Delete from Students where studentid = "+id+" ";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.executeUpdate();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//
//
//    
//
//    @Override
//    public void update(StudentModel model) {
//        try {
//            String sql =  "update Students set studentname =?, studentgender=?, studentdob=? where studentid = ? ";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, model.getName());
//            statement.setBoolean(2, model.isGender());
//            statement.setDate(3, model.getDob());
//            statement.setInt(4, model.getID());
//            statement.executeUpdate();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public ArrayList<StudentModel> SelectByDeID(int id) {
//        try {
//            String sql = "SELECT * FROM Students WHERE did ="+id+"";
//            ArrayList<StudentModel> students = new ArrayList<>();
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            ResultSet rs = statement.executeQuery();
//            while(rs.next())
//            {
//                StudentModel student = new StudentModel();
//                student.setID( rs.getInt("studentid") );
//                student.setName(rs.getString("studentname") );
//                student.setGender(rs.getBoolean("studentgender") );
//                student.setDob(rs.getDate("studentdob") );
//                student.setDeid(rs.getInt("did"));
//                students.add(student);
//            }
//            return students;
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public void insert(CafeProductModel model) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void update(CafeProductModel model) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    

    
    
    
}   
    

