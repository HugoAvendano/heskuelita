<%@ page import="com.capgemini.heskuelita.core.beans.User" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="US-ASCII">
        <title>Login Page</title>
    </head>
    <body>

        <%User us = (User)session.getAttribute ("user");%>

		<div>
			<span>Bienvenido:</span>
			<span><%= us.getName()%><span>
			<span><%= us.getLastname()%><span>

		</div>
		<div>
			<span> Email: </span>
			<span><%= us.getEmail()%> </span>
		</div>

    </body>
</html>