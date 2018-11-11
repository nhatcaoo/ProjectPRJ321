/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CafeProductModel;
import dal.ProductDAO;
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
public class ProductController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
         
            Vector<CafeProductModel> product = new Vector();
            ProductDAO daoProduct = new ProductDAO();

            int page = 1;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                page = 1;
            }
            int tempPageNumber = daoProduct.getNumberCake();//lay so san pham
            int numberOfPage = tempPageNumber / 3;
            if (tempPageNumber % 3 != 0) {
                numberOfPage++;
            }
            int temp = 3 * page - 2;

            product = daoProduct.getCake(temp);   
            request.setAttribute("Product", product);
            request.setAttribute("Page", page);
            request.setAttribute("NumberOfPage", numberOfPage);
            getServletContext().getRequestDispatcher("/User/Products.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("ErrorPage.jsp");
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
