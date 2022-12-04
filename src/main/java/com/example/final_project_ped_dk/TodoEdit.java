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

@WebServlet(name = "editTodos", value = "/edit-todos")
public class TodoEdit extends HttpServlet {

    private DBmanager dBManager;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            editTodo(request,response);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    private void editTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dBManager = new DBmanager();
        //Recupere Id du boutton
        String button = request.getParameter("edit");
        int id = Integer.parseInt(button);
        String tempDescription = request.getParameter("description");
        System.out.println("Info bouton" + id );
        Todo tempTodo = new Todo(id,tempDescription);
        dBManager.editTodo(tempTodo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos");
        dispatcher.forward(request, response);
    }

}
