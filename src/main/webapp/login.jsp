<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
<h:head>
    <title>Login Form</title>
</h:head>
<HTML>
<HEAD><TITLE> AUTHENTIFICATION</TITLE>
</HEAD>
<body>
<div id="container">

    <form method="POST" action="j_security_check">
        <h1>Sign in</h1>
        <tr>
            <td>Login :</td>
            <td><input type="text" name="j_username" value=${userName}></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="j_password" value=""></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" class="addButton" value="Login"></td>
            <td colspan="1"><input type="reset" class="deleteButton"></td>
        </tr>
    </form>
</div>
</body>
</HTML>