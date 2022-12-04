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
    <h2>New Todo</h2>
  </div>
</div>
<div id="container">
  <div id="content">
    <td><form action="add-todo" method="post"><input type="text" name="description" id="text" value="" autocomplete= "off"><button type="submit" class="addButton" name="addButton" value="">Add</button></form></td>
  </div>
</div>
<form action="list-todos" method="post"><button type="submit" class="editButton" name="editButton" value="">Return</button></form>
</body>
</html>

