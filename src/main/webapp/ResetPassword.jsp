<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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

.alert {
	margin-bottom: -30px;
	font-size: 13px;
	margin-top: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<div class="pt-5">
		<div class="global-container">
			<div class="card login-form">
				<div class="card-body">
					<h3 class="card-title text-center">Reset Password</h3>
					<div class="card-text">
						<form action="reset" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1"> Username:-> </label> <input
									type="text" class="form-control form-control-sm"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter your username" name="username"
									required="required">
							</div>
							<button type="submit" class="btn btn-primary btn-block">
								Reset</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>