<%-- 
    Document   : error
    Created on : 20-may-2017, 10:52:27
    Author     : malky
--%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"	%>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
          <section>
            <div	class="jumbotron">
                <div	class="container">
                    <h1	class="alert	alert-danger">	Se ha producido un error	
                        	</h1>
                </div>
            </div>
        </section>
        <section>
            <div	class="container">
                <p>${url}</p>
                <p>${exception}</p>
            </div>
            <div	class="container">
               
            </div>
        </section>
    </body>
</html>
