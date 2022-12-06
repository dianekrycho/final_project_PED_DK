package com.example.final_project_ped_dk;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class DBmanager {


    private static DataSource datasource;
    public DBmanager(DataSource theDatasource){
        datasource = theDatasource;
    }

    public List<Todo> loadTodos(){
        List<Todo> todoDisplay = new ArrayList<Todo>();
        Connection myConn = null;
        try {
            myConn = this.Connector();
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
            Connection connection =  datasource.getConnection();
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

    public String checkAccount(Accounts account){
        Connection myConn= null;
        PreparedStatement myStmt=null;
        ResultSet myRs = null;
        try {
            myConn = this.Connector();
            String sql = "select * from roles where userName =?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, account.getUserName());
            myRs = myStmt.executeQuery();
            myRs.next();
            String role = myRs.getString("role");
            System.out.println(role);
            //select * FROM accounts WHERE userName = 'DianeKrychowski' AND userPassword = 'password'
            return role;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }
}
