/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Sap-lap
 */
public abstract class RequiredLoginBaseController extends HttpServlet {

  private boolean checkLogin(HttpServletRequest request)
  {
     //System.out.println(request.getServletPath());
     Account account = (Account)request.getSession(true).getAttribute("account");
     if(account != null)
         return true;
     else
     {
         Cookie[] cookies = request.getCookies();
         if(cookies == null)
             return false;
         else
         {
             String user = null;
             String pass = null;
             for (Cookie cooky : cookies) {
                 if(cooky.getName().equals("user"))
                 {
                     user = cooky.getValue();
                 }
                 else if(cooky.getName().equals("pass"))
                 {
                     pass = cooky.getValue();
                 }
                 if(user != null && pass !=null)
                     break;
             }
             if(user != null && pass !=null)
             {
                 AccountDAO db = new AccountDAO();
                 account = db.getAccount(user, pass);
                 if(account != null)
                 {
                     request.getSession(true).setAttribute("account", account);
                     return true;
                 }
                 else
                     return false;
             }
             else
                 return false;
             
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
        if(checkLogin(request))
        {
            processGet(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }
    
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

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
        if(checkLogin(request))
        {
            processPost(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
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
