/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import Model.AdminAccount;
import dal.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginDAO dao = new LoginDAO();
            List<AdminAccount> list = dao.selectAccount();
            String error = "";
            int checkTemp = 0;
            int checkExited = 0;
            for (int i = 0; i < list.size(); i++) {
                
                System.out.println(username);
                System.out.println(list.get(i).getUserName());
                if (username.equals(list.get(i).getUserName())) {
                    checkExited = 1;
                    if (!password.equals(list.get(i).getPassword())) {
                        checkTemp = 1;
                        error = "your password is not correct";
                        break;
                    }
                }
            }
            System.out.println("checkTemp= " + checkTemp);
            System.out.println("Error 1: " + error);
            String url="";
            if (checkTemp == 0) {
                if (checkExited == 0) {
                    error = "username not exists";
                    url = "Admin/AdminLogin.jsp?error=" + error;
                }else{
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("psw", password);
                   url = "Admin/AdminProduct.jsp"; 
                }
            }else{
                 url = "Admin/AdminLogin.jsp?error=" + error;
            }
//            
//      
            response.sendRedirect(url);

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
