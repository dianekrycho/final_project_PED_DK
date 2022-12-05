package com.example.final_project_ped_dk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "deleteTodo", value = "/delete-todos")
public class DeleteTodo extends HttpServlet {

    private DBmanager dBManager;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            deleteTodo(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dBManager = new DBmanager();
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
