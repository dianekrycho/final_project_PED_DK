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

@WebServlet(name = "addTodo", value = "/add-todo")
public class addTodo extends HttpServlet {

    private DBmanager dBManager;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            addTodo(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private void addTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dBManager = new DBmanager();
        String tempDescription = request.getParameter("description");
        Todo tempTodo = new Todo(0,tempDescription);
        dBManager.addTodo(tempTodo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/load-new");
        dispatcher.forward(request, response);
    }

}