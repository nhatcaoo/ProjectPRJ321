/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class HomePage extends HttpServlet {

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
          try {
            HomeContentDAO daoHomeContent = new HomeContentDAO();
            ShareContentDAO daoShareContent = new ShareContentDAO();
            Contact contact =new Contact();
            CakeDAO daoCake = new CakeDAO();
            ContactDAO daoContact = new ContactDAO();
            Vector<Cake> vecCake = new Vector();
            HomeContent homeContent = new HomeContent();
            Vector<ShareContent> vecShareContent = new Vector();
            String service = request.getParameter("service");
            System.out.println("service----"+service);
            if (service == null || service.equals("")) {
                service = "display";
            }
             System.out.println("service----"+service);
            if (service.equals("display")) {
                homeContent = daoHomeContent.getHomeContent();
                vecShareContent = daoShareContent.getShareContent();
                vecCake = daoCake.getCake(1, 2);
                contact = daoContact.getContact(); 
                Vector<Contact> vecContact = new Vector();
                //vecContact = daoContact.getContact();
                
//                //                Get image url   Tạm bỏ đoạn này
//                InitialContext initialContext;
//                Context initContext = new InitialContext();
//                Context envContext = (Context) initContext.lookup("java:/comp/env");
//                String urlIcon = (String) envContext.lookup("Icon");
//                String urlHomeContentImage = (String) envContext.lookup("HomeImage");
//                String urlImage = (String) envContext.lookup("Cake");
//
//                for (ShareContent x : vecShareContent) {
//                    x.setUrlIcon(urlIcon + "/" + x.getUrlIcon());
//                }
//                homeContent.setUrlImage(urlHomeContentImage + "/" + homeContent.getUrlImage());
//                
//                for(Cake x : vecCake){
//                    x.setUrlImage(urlImage + "/" + x.getUrlImage());
//                }
                request.setAttribute("Contact", contact);
                request.setAttribute("Cake", vecCake);
                request.setAttribute("HomeContent", homeContent);
                request.setAttribute("ShareContent", vecShareContent);
                getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("ErrorPage.jsp");
        }
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
