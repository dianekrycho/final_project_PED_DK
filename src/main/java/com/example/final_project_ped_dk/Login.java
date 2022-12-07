package com.example.final_project_ped_dk;

import com.mysql.cj.Session;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.Principal;

@WebServlet(name = "login", value = "/login-check")
public class Login extends HttpServlet {

    private DBmanager dBManager;
    private Accounts testAccount;

    private DataSource dataSource;


    private DataSource getDataSource() throws NamingException {
        String jndi="java:comp/env/jdbc/finalproject" ;
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup(jndi);
        return dataSource;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            dataSource= getDataSource();
            dBManager = new DBmanager(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            login(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal principal = request.getUserPrincipal();
        request.setAttribute("username", principal.getName());
        testAccount = new Accounts(principal.getName(), request.getParameter("password"), "");
        String loginQuery = dBManager.checkAccount(testAccount);
        System.out.println(loginQuery);
        if (loginQuery != null){
            if (loginQuery.equals("admin")){
                Cookie ck=new Cookie("userName",testAccount.getUserName());
                response.addCookie(ck);
                request.setAttribute("userName",testAccount.getUserName());
                response.setHeader( "Pragma", "no-cache" );
                response.setHeader( "Cache-Control", "no-cache" );
                response.setDateHeader( "Expires", 0 );
                HttpSession session = request.getSession();
                session.setAttribute("username", principal.getName());
                session.setAttribute("role", loginQuery);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos");
                dispatcher.forward(request, response);
            } else {
                Cookie ck=new Cookie("userName",testAccount.getUserName());
                request.setAttribute("userName",testAccount.getUserName());
                response.addCookie(ck);
                response.setHeader( "Pragma", "no-cache" );
                response.setHeader( "Cache-Control", "no-cache" );
                response.setDateHeader( "Expires", 0 );
                HttpSession session = request.getSession();
                session.setAttribute("username", principal.getName());
                session.setAttribute("role", loginQuery);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos-students");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
