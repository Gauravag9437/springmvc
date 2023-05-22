<%@page import="springmvc.model.Tshirt"%>
<%@page import="springmvc.controller.RequiredTshirtController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@page import="springmvc.model.User"%>
<%
	User loggedINAdmin = (User) session.getAttribute("currentAdmin");
%>
<!doctype html>
<html lang="en">
<head>

<style type="text/css">
.hdr-title {
	text-align: center;
}

.form-table>tr, .form-table>td {
	border: 3px solid #000000;
}

.brand-img {
	width: 160px;
}

.content-table {
	border-collapse: collapse;
}

.content-table>tr, content-table>td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

.right-hdr-item {
	width: 200px;
	position: fixed;
	top: 0;
	right: 10px;
	display: flex;
}

.col-lg-5 {
	position: fixed;
	right: 32px;
	top: 18px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	display: flex;
}

li {
	float: left;
}

.show-content {
	margin-left: 20px;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
</head>
<body>
	<%-- <div class="text-center">
		<h2>Hello user ${user.username } !!!!!!</h2>
		<h4>Welcome!!!!</h4>
	</div> --%>

	<div class="admin-page-wrapper">
		<div class="admin-header">
			<div class="hdr-title">
				<h2>T-Shirt Search Tool</h2>
				<nav class="right-hdr-item">
					<h3>Hii <%=loggedINAdmin.getUsername()%>!!</h3>
				</nav>
			</div>
		</div>
		<div class="col-lg-5">
			<form action="logout" method="post">
				<input type="submit" value="Logout" class="btn btn-danger"></input>
			</form>
		</div>
		<hr>
		<section class="container">
			<div style="border: 2px solid gray; width: 30%; padding: 30px">

				<div class="admin-form" style="border-color: #000000">

					<div>
						<b>Please enter the details here to search</b>
					</div>

					<%
						String error = (String) request.getAttribute("error1");
						if (error != null) {
					%>
					<div class="alert alert-primary" role="alert"><%=error%></div>
					<%
						}
						request.removeAttribute("error1");
					%>
					<form action="search" method="post">
						<input type="hidden" name="operation" value="addproduct" />
						<table class="form-table" border="0" cellpadding="10px"
							cellspacing="5px">
							<tr>
								<td>Color :</td>
								<td><input type="text" name="color"
									placeholder="colour(ex:Black)" required></td>
							</tr>
							<tr>
								<td>Size :</td>
								<td><input type="text" name="size"
									placeholder="Size(ex:S,M,L,XL)" required></td>
							</tr>
							<tr>
								<td>Gender :</td>
								<td><input type="text" name="gender"
									placeholder="Size(M,F,U)" required></td>
							</tr>
							<tr>
								<td>Preference :</td>
								<td><input type="text" name="preference"
									placeholder="(ex:Price,Rating, Both)" required></td>
							</tr>
							<tr>

								<td>
									<div class="text-center">
										<button id="submit-button" type="submit"
											class="btn btn-primary">Submit</button>
									</div>
								</td>
							</tr>
						</table>
					</form>

				</div>
			</div>
		</section>
		<br> <br>
		<%
			List<Tshirt> list = RequiredTshirtController.getList();
		%>

		<div class="show-content">
			<table class="content-table" border="1" cellpadding="10px"
				cellspacing="5px">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Size</th>
					<th>Color</th>
					<th>Gender</th>
					<th>Price</th>
					<th>Rating</th>
					<th>Availability</th>
				</tr>
				<%
					if (list == null) {

					} else {
						for (Tshirt itr : list) {
				%>
				<tr>

					<td><%=itr.getId()%></td>
					<td><%=itr.getName()%></td>
					<td><%=itr.getSize()%></td>
					<td><%=itr.getColor()%></td>
					<td><%=itr.getGender()%></td>
					<td><%=itr.getPrice()%></td>
					<td><%=itr.getRating()%></td>
					<td><%=itr.getAvailability()%></td>

				</tr>
				<%
					}
				%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Total number of products found</td>
					<%
						if (list.size() == 0) {
					%>
					<td style="color: red;"><%=list.size()%></td>
					<%
						} else {
					%>
					<td style="color: green;"><%=list.size()%></td>
					<%
						}
						}
					%>

				</tr>
			</table>
		</div>
	</div>

</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</html>