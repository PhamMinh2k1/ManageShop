/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAOCategories;
import DAL.DAOProducts;
import Models.Categories;
import Models.Products;
import Models.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Admin
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
        request.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String tmp = request.getParameter("go");
            DAOProducts daoP = new DAOProducts();
            ArrayList<Products> listP = new ArrayList<>();
            ArrayList<Categories> listC = new DAOCategories().loadCategories();
            request.setAttribute("listC", listC);
            if (tmp.equals("loadAll")) {
                listP = daoP.loadProduct();
                request.setAttribute("list", listP);
                request.getRequestDispatcher("LoadProducts.jsp").forward(request, response);
            }
            if (tmp.equals("loadByCid")) {
                String cid = request.getParameter("cid");
                listP = daoP.loadProductByCid(cid);
                request.setAttribute("list", listP);
                request.getRequestDispatcher("LoadProducts.jsp").forward(request, response);
            }
            if (tmp.equals("loadByName")) {
                String name = request.getParameter("name").trim();
                listP = daoP.loadProductByName(name);
                request.setAttribute("list", listP);
                request.getRequestDispatcher("LoadProducts.jsp").forward(request, response);
            }
            if (tmp.equals("loadForSeller")) {
                String uid = request.getParameter("uid");
                listP = daoP.loadProductByUid(uid);
                request.setAttribute("list", listP);
                request.getRequestDispatcher("LoadProducts.jsp").forward(request, response);
            }
            if (tmp.equals("showEdit")) {
                String pid = request.getParameter("pid");
                Products p = daoP.getProductById(pid);
                request.setAttribute("p", p);
                request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
            }
            if (tmp.equals("updateProduct")) {
                String pid = request.getParameter("pid");
                String pname = request.getParameter("pname");
                String price = request.getParameter("price");
                String infor = request.getParameter("infor");
                String image = request.getParameter("image");
                String cid = request.getParameter("cid");
                String quantity = request.getParameter("quantity");
                String discount = request.getParameter("discount");
                daoP.updateProduct(pid, pname, price, infor, image, cid, quantity, discount);
                request.getRequestDispatcher("loadProducts?go=loadAll").forward(request, response);

            }
            if (tmp.equals("loadByPrice")) {
                String from = request.getParameter("priceFrom");
                String to = request.getParameter("priceTo");
                if(from.equals(null)){
                    from = "0";
                }
                if(to.equals(null)){
                    to = "0";
                }
                listP = daoP.getByPrice(from, to);
                request.setAttribute("list", listP);
                request.getRequestDispatcher("LoadProducts.jsp").forward(request, response);
            }
            if (tmp.equals("addProduct")) {
                String pid = new Validate().RamdomCode();
                String pname = request.getParameter("pname");
                String price = request.getParameter("price");
                String infor = request.getParameter("infor");
                String image = request.getParameter("image");
                String cid = request.getParameter("cid");
                String quantity = request.getParameter("quantity");
                String discount = request.getParameter("discount");
                String uid = request.getParameter("uid");
                daoP.addProducts(pid, pname, price, infor, image, cid, quantity, discount, uid);

                request.getRequestDispatcher("loadProducts?go=loadAll").forward(request, response);
            }
            if (tmp.equals("deleteProduct")) {
                String pid = request.getParameter("pid");
                daoP.deleteProduct(pid);
                response.sendRedirect("loadProducts?go=loadAll");
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
