<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<spring:url var="css" value="/static/css"></spring:url>
<spring:url var="js" value="/static/js"></spring:url>
<spring:url var="images" value="/static/images"></spring:url>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title }</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css }/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Dark Theme CSS -->
<link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap Datatables . ORDER is IMPORTANT -->
<link href="${css }/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body id="masterBody">
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${flowExecutionUrl }&_eventId_home">Home</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<h3>This will be triggered by flow</h3>
			</div>
		</div>
		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<!-- jquery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js }/bootstrap.min.js"></script>

		<!-- jQuery datatable plugin. THis order is important -->
		<!-- Should Come after jquery.js file -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Bootstrap Datatable Script -->
		<!-- Order is IMPORTANT -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- Bootbox -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self Coded javascript -->
		<script src="${js }/myapp.js"></script>
		<script src="${js }/currency.js"></script>
		<script src="${js }/transition.js"></script>
		<script src="${js }/jquery-ui.min.js"></script>

	</div>
</body>

</html>
