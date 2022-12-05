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
<% List<Todo> todos = (List<Todo>)request.getAttribute("TODOS_LIST");
    String name = "";
    Cookie[] cookies = request.getCookies();
    for ( int i=0; i<cookies.length; i++) {
        Cookie cookie = cookies[i];
        if ("userName".equals(cookie.getName()))
            name = cookie.getValue();
    }
%>
<body>
<div id="wrapper">
    <div id="header">
        <h2>List of TODOS Students</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <form action = "log-out">
            <input type="submit" value="Logout">  Welcome : <%=name%> </input>
        </form>
        <table>
            <tr>
                <th>TODO Description</th>
            </tr>
            <%for(Todo tempTodo:todos) {
            %>
            <tr>
                <td><form><input type="text" name="description" id="text<%=tempTodo.getId()%>" value="<%= tempTodo.getTodoDesc() %>" autocomplete= "off"></form></td>
            </tr>
            <%;} %>
        </table>
    </div>
</div>
</body>
</html>
