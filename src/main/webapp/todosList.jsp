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
<%=todos %>
<div id="wrapper">
    <div id="header">
        <h2>List of TODOS</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>TODO Description </th>
            </tr>
            <% int i = 0;
                for(Todo tempTodo:todos) {
            i++;
            %>
            <tr>
                <td><form><input type="text" id="<%= i %>" value="<%= tempTodo.getTodoDesc() %>" autocomplete= "off"><button type="button" id="<%= i %>">Delete</button></form></td>
            </tr>
            <%;} %>
        </table>
    </div>
</div>
<form action = "edit-todos">
    <input type="submit" value="Update">

    <%



    %>

</form>
</body>
</html>
