/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.*;
import Models.*;
import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountsController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {

            String tmp = request.getParameter("go");
            HttpSession session = request.getSession();
            DAOAccounts daoA = new DAOAccounts();
            DAOQuestions daoQ = new DAOQuestions();
            DAOUsers daoU = new DAOUsers();
            DAOProducts daoP = new DAOProducts();
            Validate v = new Validate();
            ArrayList<Products> listP = new ArrayList<>();
            ArrayList<Questions> listQ = daoQ.loadQuestion();
            request.setAttribute("listQ", listQ);
            request.setAttribute("status", "hidden");
            if (tmp.equals("login")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Accounts acc = daoA.getAccounts(username, password);
                if (acc != null) {
                    Users user = daoU.getUser(acc.getUid());
                    session.setAttribute("user", user);
                    session.setAttribute("acc", acc);
                    session.setMaxInactiveInterval(300);
                    request.getRequestDispatcher("loadProducts?go=loadAll").forward(request, response);
                } else {
                    request.setAttribute("mess", "Wrong username or password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
            if (tmp.equals("logout")) {
                session.removeAttribute("acc");
                session.setMaxInactiveInterval(0);
                response.sendRedirect("Home.jsp");
            }
            if (tmp.equals("showSignIn")) {

                request.getRequestDispatcher("SignIn.jsp").forward(request, response);
            }
            if (tmp.equals("signIn")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String rePassword = request.getParameter("rePassword");
                String qid = request.getParameter("qid");
                String answer = request.getParameter("answer");
                String uid = v.RamdomCode();
                if (username.isEmpty() || password.isEmpty()
                        || rePassword.isEmpty() || answer.isEmpty()) {
                    request.setAttribute("mess", "Be sure to fill all information.");
                    request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                } else {
                    if (daoA.checkExist(username) == null) {
                        if (rePassword.equals(password)) {
                            daoA.signUp(uid, username, password, qid, answer);
                            response.sendRedirect("Login.jsp");
                        } else {
                            request.setAttribute("mess", "Password and Re-password aren't equal.");
                            request.setAttribute("username", username);
                            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mess", "Username have already existed.");
                        request.setAttribute("username", username);
                        request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                    }
                }

            }
            if (tmp.equals("showUserInfor")) {
                String uid = request.getParameter("uid");
                listP = daoP.loadProductByUid(uid);
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("UserInfor.jsp").forward(request, response);
            }
            if (tmp.equals("updateInfor")) {
                String name = request.getParameter("name");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String uid = request.getParameter("uid");
                daoU.updateUser(name, dob, address, phone, email, gender, uid);
                request.getRequestDispatcher("home").forward(request, response);
            }
            if (tmp.equals("toChangePass")) {

                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }
            if (tmp.equals("checkAccount")) {
                String username = request.getParameter("username");
                int qid = Integer.parseInt(request.getParameter("qid"));
                String answer = request.getParameter("answer");
                Accounts acc = daoA.checkExist(username);
                if (acc != null) {
                    if (qid == acc.getQid() && answer.equals(acc.getAnswer())) {
                        request.setAttribute("username", acc.getUsername());
                        request.setAttribute("status", "");
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    } else {
                        request.setAttribute("username", acc.getUsername());
                        request.setAttribute("mess", "Answer or question wrong.");
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mess", "Account doesn't exist.");
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
            }
            if (tmp.equals("changePass")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String rePassword = request.getParameter("rePassword");
                if (!password.isEmpty() && !rePassword.isEmpty()) {
                    if (rePassword.equals(password)) {
                        daoA.changePass(username, password);
                        response.sendRedirect("Login.jsp");
                    } else {
                        request.setAttribute("username", username);
                        request.setAttribute("status", "");
                        request.setAttribute("mess2", "Passwords are not equal.");
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("username", username);
                    request.setAttribute("status", "");
                    request.setAttribute("mess2", "Please input new password.");
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
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
