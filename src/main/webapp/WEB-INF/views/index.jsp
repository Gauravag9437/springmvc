<%@page import="java.time.LocalDateTime"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<style>
html {
	height: 100%;
}

body {
	height: 100%;
	background-color: #f5f5f5;
}

.global-container {
	height: 100%;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	/* 	background-color: #f5f5f5; */
}

form {
	padding-top: 10px;
	font-size: 14px;
	margin-top: 30px;
}

.card-title {
	font-weight: 350;
}

.btn {
	font-size: 14px;
	margin-top: 20px;
}

.login-form {
	width: 330px;
	margin: 20px;
}

.sign-up {
	text-align: center;
	padding: 20px 0 0;
}

.alert {
	margin-bottom: -30px;
	font-size: 13px;
	margin-top: 20px;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Nagarro</title>
</head>
<body>
	<div class="pt-5">
		<div class="global-container">
			<div class="card login-form">
				<div class="card-body">
					<h3 class="card-title text-center">User Login</h3>
					<%
						String logout = (String) request.getAttribute("logout");
						if (logout != null) {
					%>
					<div class="alert alert-success" role="alert">${logout }</div>
					<%
						}
						request.removeAttribute("logout");
					%>
					<%
						String isExist = (String) request.getAttribute("error");

						if (isExist != null) {
					%>
					<div class="alert alert-danger" role="alert">User not
						exist!!!!</div>
					<%
						}
						request.removeAttribute("check");
					%>

					<%
						String reset = (String) request.getAttribute("password");
						if (reset != null) {
					%>
					<div class="alert alert-primary" role="alert">
						your password is:->
						<%=reset%></div>
					<%
						}
						request.removeAttribute("password");
					%>
					<div class="card-text">
						<form action="login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1"> username </label> <input
									type="text" class="form-control form-control-sm"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter your username" name="username">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1"> Password </label> <input
									type="password" class="form-control form-control-sm"
									id="exampleInputPassword1" placeholder="Enter your password"
									name="password">
							</div>
							<button type="submit" class="btn btn-primary btn-block">
								Sign in</button>

							<div class="sign-up">
								<a href="ResetPassword.jsp"
									style="float: left; font-size: 12px;"> Forgot password? </a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>
