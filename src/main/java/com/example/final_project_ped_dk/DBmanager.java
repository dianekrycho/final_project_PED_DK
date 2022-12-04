package com.example.final_project_ped_dk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBmanager {
    public List<Todo> loadTodos(){
        List<Todo> todoDisplay = new ArrayList<Todo>();
        Connection myConn= this.Connector();
        try {
            Statement myStmt= myConn.createStatement();
            String sql = "select id, todoDesc from todo";
            ResultSet myRs= myStmt.executeQuery(sql);
            while (myRs.next()) {
                Todo t = new Todo(myRs.getInt("id"),
                        myRs.getString("todoDesc")
                );
                todoDisplay.add(t);
            }
            this.close(myConn, myStmt, myRs);
            return todoDisplay;
        } catch (SQLException e) {

            e.printStackTrace();

            return null;
        }
    }
    public Connection Connector(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "password");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myStmt != null)
                myStmt.close();
            if (myRs != null)
                myRs.close();
            if (myConn != null)
                myConn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void addTodo(Todo todo){
        if (todo.getTodoDesc() == null){
            // COMPLETER
        }
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = this.Connector();
            String sql = "insert into todo (id, todoDesc) values(?, ?)";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, 0);
            myStmt.setString(2, todo.getTodoDesc());
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
    public void deleteTodo(Todo todo){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        int id = todo.getId();
        try {
            myConn = this.Connector();
            String sql = "DELETE FROM todo WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, id);
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
    public void editTodo(Todo todo){
        if (todo.getTodoDesc()== null){
            // A completer
        }
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = this.Connector();
            String sql = "update todo set todoDesc=? where id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, todo.getTodoDesc());
            myStmt.setInt(2, todo.getId());
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }

    public void addAccount(Accounts account){
        if (account.getUserPassword()== null){
            // COMPLETER
        }
        if (account.getUserName()== null){
            // COMPLETER
        }
        if (account.getUserRole()== null){
            // COMPLETER
        }
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = this.Connector();
            String sql = "insert into accounts (userName, userPassword, userRole) values(?, ?,?)";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, account.getUserName());
            myStmt.setString(2, account.getUserPassword());
            myStmt.setString(3, account.getUserRole());
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
    public void deleteAccount(Accounts account){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        String userName = account.getUserName();
        try {
            myConn = this.Connector();
            String sql = "DELETE FROM accounts WHERE userName = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userName);
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
    public void editPassword(Accounts account){
        if (account.getUserPassword()== null){
            // A completer
        }
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = this.Connector();
            String sql = "update accounts set userPassword=? where userName=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, account.getUserPassword());
            myStmt.setString(2, account.getUserName());
            myStmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
}
