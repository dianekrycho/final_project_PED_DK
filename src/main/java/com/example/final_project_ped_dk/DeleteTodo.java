package com.example.final_project_ped_dk;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "deleteTodo", value = "/delete-todos")
public class DeleteTodo extends HttpServlet {

    private DBmanager dBManager;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Cookie[] cookies = request.getCookies();
            if(cookies!= null){
                for(Cookie cookie:cookies){
                    if(cookie.getName().equals("userName"))
                        request.setAttribute("userName", cookie.getValue()) ;
                }
            }
            deleteTodo(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Cookie[] cookies = request.getCookies();
            if(cookies!= null){
                for(Cookie cookie:cookies){
                    if(cookie.getName().equals("userName"))
                        request.setAttribute("userName", cookie.getValue()) ;
                }
            }
            deleteTodo(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recupere Id du boutton
        String button = request.getParameter("deleteButton");
        int id = Integer.parseInt(button);
        System.out.println("Info bouton" + id );
        Todo tempTodo = new Todo(id,"");
        dBManager.deleteTodo(tempTodo);
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos");
        dispatcher.forward(request, response);
    }

}
