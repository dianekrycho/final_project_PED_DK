package com.example.final_project_ped_dk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListStudents", value = "/list-todos-students")
public class ListTodosStudents extends HttpServlet {

    private DBmanager dBManager;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            listTodos(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todosListStudent.jsp");
        dispatcher.forward(request, response);
    }

}
