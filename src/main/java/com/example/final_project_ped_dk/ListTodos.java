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

@WebServlet(name = "todoList", value = "/list-todos")
public class ListTodos extends HttpServlet {

    private DBmanager dBManager;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            listTodos(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private void listTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dBManager = new DBmanager();
        List<Todo> todoList = dBManager.loadTodos();
        request.setAttribute("TODOS_LIST", todoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todosList.jsp");
        dispatcher.forward(request, response);
    }

}
