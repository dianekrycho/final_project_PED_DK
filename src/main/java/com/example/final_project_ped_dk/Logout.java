package com.example.final_project_ped_dk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "logout", value = "/log-out")
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            logout(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            logout(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Cookie ck = new Cookie("userName", "");
            ck.setMaxAge(0);
            response.addCookie(ck);
            response.setHeader( "Pragma", "no-cache" );
            response.setHeader( "Cache-Control", "no-cache" );
            response.setDateHeader( "Expires", 0 );
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login-check");

    }

}