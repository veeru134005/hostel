<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resoureces/css" />
<spring:url var="js" value="/resoureces/js" />
<spring:url var="images" value="/resoureces/images" />


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Mobile - ${title}</title>

<!-- style for boostrap -->


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<script type="text/javascript">
		window.menu = '${title}';
		window.contextRoot = '${context}'
	</script>


	<!-- Loading the nava bar -->

	<%@include file="./shared/nav.jsp"%>

	<!-- Loading the home page -->

	<!-- Loading the content -->

	<div class="wrapper">

		<div class="content">



			<c:if test="${userClickHome==true}">
				<%@include file="./shared/home.jsp"%>
			</c:if>

			<!-- Loading the About page -->

			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">

				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Loading the single page -->
			<c:if test="${userClickShowProudct ==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

		</div>


		<!-- Loading the footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- JavaScript -->
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>




	</div>
</body>

</html>
