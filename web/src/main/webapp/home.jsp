<%@ page import="com.capgemini.heskuelita.core.beans.Student" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="US-ASCII">
        <title>Login Page</title>
    </head>
    <body>

        <% Student st = (Student)session.getAttribute ("student");%>

		<div>
			<span>Bienvenido:</span>
			<span><%= st.getName()%><span>
			<span><%= st.getLastname()%><span>
		</div>
		<div>
			<span> Email: </span>
			<span><%= st.getUser().getEmail()%> </span>
		</div>
		</div>
			<a href="editProfile.jsp" class="btn btn-success">
				Editat Perfil
			</a>
		<div>

    </body>
</html>