<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<br>

<title>Students Directory</title>
</head>

<body>

	<div class="container">

		<h3>Students Directory</h3>
		<hr>

		<div class="d-flex justify-content-around">

			<!-- Adding buttons -->
			<a href="/StudentManagement/students/showFormForAdd"
				class="btn btn-primary btn-sm mb-3 mx-auto"> Add Student </a> 
				
				<a href="/StudentManagement/students/printAllStudents"
				class="btn btn-primary btn-sm mb-3 mx-auto"> Print All Students </a> 
				
				<a href="/StudentManagement/logout"
				class="btn btn-primary btn-sm mb-3 mx-auto"
				onclick="if (!(confirm('Are you sure you want to logout?'))) return false">
				Logout </a>
				
		</div>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Course</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.id}"></c:out></td>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>
						<td><c:out value="${tempStudent.course}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>

						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentManagement/students/showFormForUpdate?studentId=${tempStudent.id}"
							class="btn btn-primary btn-sm"> Update </a> <!-- Add "delete" button/link -->

							<!-- Add "delete" button/link --> <a
							href="/StudentManagement/students/delete?studentId=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>

							<!-- Add "view" button/link --> <a
							href="/StudentManagement/students/viewStudent?studentId=${tempStudent.id}"
							class="btn btn-info btn-sm"> View </a>
						</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>

	</div>

</body>
</html>