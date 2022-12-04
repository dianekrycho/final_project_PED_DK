<%@ page import="com.example.final_project_ped_dk.Todo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project_ped_dk.ListTodos" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.swing.text.Document" %>

<html>
<head>
    <title>Todos List</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<% List<Todo> todos = (List<Todo>)request.getAttribute("TODOS_LIST");%>
<body>
<div id="wrapper">
    <div id="header">
        <h2>List of TODOS</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>TODO Description <form><button type="submit" class="addButton" name="addButton" value="" formaction="load-new">New Todo</button></form></th>
            </tr>
            <%for(Todo tempTodo:todos) {
            %>
            <tr>
                <td><form action="delete-todos" method="post"><input type="text" name="description" id="text<%=tempTodo.getId()%>" value="<%= tempTodo.getTodoDesc() %>" autocomplete= "off"><button type="submit" class="deleteButton" name="deleteButton" value="<%=tempTodo.getId()%>">Delete</button><button type="submit" class="editButton" name="edit" value="<%=tempTodo.getId()%>" formaction="edit-todos">Edit</Button></form></td>
            </tr>
            <%;} %>
        </table>
    </div>
</div>
</body>
</html>
