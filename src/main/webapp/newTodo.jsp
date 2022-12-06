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
  }%>
<body>
<div id="wrapper">
  <div id="header">
    <h2>New Todo</h2>
  </div>
</div>
<div id="container">
  <div id="content">
    <form action = "log-out">
      <input type="submit" value="Logout">  Welcome : ${userName} </input>
    </form>
    <td><form action="add-todo" method="post"><input type="text" name="description" id="text" value="" autocomplete= "off"><button type="submit" class="addButton" name="addButton" value="">Add</button></form></td>
  </div>
</div>
<form action="list-todos" method="post"><button type="submit" class="editButton" name="editButton" value="">Return</button></form>
</body>
</html>

