package com.example.final_project_ped_dk;

import com.mysql.cj.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "login", value = "/login-check")
public class Login extends HttpServlet {

    private DBmanager dBManager;
    private Accounts testAccount;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            login(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        testAccount = new Accounts(request.getParameter("userName"), request.getParameter("userPassword"), "");
        System.out.println(testAccount.getUserName());
        System.out.println(testAccount.getUserPassword());
        dBManager = new DBmanager();
        String loginQuery = dBManager.checkAccount(testAccount);
        if (loginQuery != null){
            if (loginQuery.equals("admin")){
                Cookie ck=new Cookie("userName",testAccount.getUserName());
                response.addCookie(ck);
                request.setAttribute("userName",testAccount.getUserName());
                response.setHeader( "Pragma", "no-cache" );
                response.setHeader( "Cache-Control", "no-cache" );
                response.setDateHeader( "Expires", 0 );
                RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos");
                dispatcher.forward(request, response);
            } else {
                Cookie ck=new Cookie("userName",testAccount.getUserName());
                //HttpSession session = request.getSession();
                //session.setAttribute("userName",testAccount.getUserName());
                request.setAttribute("userName",testAccount.getUserName());
                response.addCookie(ck);
                response.setHeader( "Pragma", "no-cache" );
                response.setHeader( "Cache-Control", "no-cache" );
                response.setDateHeader( "Expires", 0 );
                RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos-students");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
