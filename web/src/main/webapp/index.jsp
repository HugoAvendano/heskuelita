<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Último CSS compilado y minificado -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

	<!-- Libreia Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<!-- Último javascript compilado -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

	<!-- Hoja de Estilos para el formulario Login-->
	<link rel="stylesheet" type="text/css" href="css/styleFormLogin.css">
</head>
<body>
	<div class="container " style="background-image: url(../imagenes/background-login.jpeg);">

			<div class="wrapper-login">
				<h2>Welcome</h2>
				<div class="wrapper">
					<div class="img" style="background-image: url(imagenes/users2.jpg);"></div>
				</div>
				<div class="wrapper" >
					<form class="form-horizontal col-sm-10 col-xs-10" action = "login" method="post">
						<div class="form-group">
							<label  class="control-label" for="user"> Email </label>
							<div>
								<input type="text" class="form-control" name="ctrlName" id="user">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label" for="password"> Password </label>
							<input type="password" class="form-control" name="ctrlPassword" id="password">
						</div>
						<div class="form-group">
    						<div class="col-sm-offset-2 col-sm-8">
      							<button type="submit" class="btn btn-success btn-block">Login</button>
   				 			</div>
  						</div>
					</form>
				</div>
				<div class="wrapper">
					<a href="SignUp-form.html">
							<h3>Create Account</h3>
					</a>
				</div>
			</div>
	<div>
</body>
</html>