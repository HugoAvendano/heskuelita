<%@ page import = "com.capgemini.heskuelita.core.beans.Student" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    	<title></title>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">

    	<!-- Último CSS compilado y minificado -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    	<!-- Libreia Jquery -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    	<!-- Último javascript compilado -->
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    	<!-- font-awesome-->
    	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>
	<% Student st = (Student)session.getAttribute("student"); %>
	<div class="container">
		<h2>EDIT PROFILE</h2>
		<form class="form-horizontal" action="signUp" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name"> Name: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ctrlName" id="name" value = <%=st.getName() %> >
				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName"> Lastname: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ctrlLastname" id="lastName" value= <%=st.getLastname() %>>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="birthday "> Birthday: </label>
				<div class="col-sm-8">
					<input type="date" class="form-control" name="ctrlBirthdate" id="birthday" min="1919/1/1">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="documentationType"> Documentation Type : </label>
				<div class="col-sm-8">
					<label class="radio-inline col-sm-2"><input type="radio" name="ctrlDocType" value="dni" <%=((st.getDocType().equals("dni"))?"checked":"")%>> DNI </label>
					<label class="radio-inline col-sm-2"><input type="radio" name="ctrlDocType" value="passport"  <%=((st.getDocType().equals("passport"))?"checked":"")%>> PASSPORT </label>
					<label class="radio-inline col-sm-2"><input type="radio" name="ctrlDocType" value="other"  <%=((st.getDocType().equals("other"))?"checked":"")%>> OTHER </label>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="identification"> Identification: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ctrlIdentification" id="identification" value = <%=st.getLastname() %>>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="gender"> Gender: </label>
				<div class="col-sm-8">
					<label class=" radio-inline col-sm-2">
						<input type="radio" name="ctrlGender" value="female" checked>
						<i class="fas fa-female"> </i>
						FEMALE
					</label>
					<label class=" radio-inline col-sm-2">
						<input type="radio" name="ctrlGender" value="male" checked>
						<i class="fas fa-male"> </i>
						MALE
					</label>
				</div>
			</div>



			<div class="form-group">
				<label class="control-label col-sm-2" for="user"> UserName(Email) : </label>
				<div class="col-sm-8">
					<input type="email" class="form-control" name="ctrlEmail" id="user" value=<%= st.getUser().getEmail() %>>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="password"> Password: </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="ctrlPassword" id="password" value=<%= st.getUser().getPassword() %> >
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordRepeat"> Repeat Password: </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="ctrlPassword" id="passwordRepeat" value=<%= st.getUser().getPassword() %> >
				</div>
			</div>

			<div class="form-group">
  					<label  class="control-label col-sm-2" for="question">Security Question:</label>
					<div class="col-sm-8">
						<select class="form-control" name="ctrlQuestion" id="question">
	    					<option value="0">Select a question</option>
	    					<option value="What was the name of your first pet?" <%=((st.getUser().getSecQuestion().equals("What was the name of your first pet?"))?"selected":"") %> >What was the name of your first pet?</option>
	    					<option value="Which is your favorite color?" <%=((st.getUser().getSecQuestion().equals("Which is your favorite color?"))?"selected":"") %> >Which is your favorite color?</option>
	    					<option value="What is your favorite book?" <%=((st.getUser().getSecQuestion().equals("What is your favorite book?"))?"selected":"") %>>What is your favorite book?</option>
  						</select>
					</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="answer"> Answer: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ctrlAnswer" id="answer" value= <%= st.getUser().getSecAnswer()%> >
				</div>
			</div>

			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-8">
      				<button type="submit" class="btn btn-success btn-block">Submit</button>
   				 </div>
  			</div>
		</form>
	</div>
</body>
</html>