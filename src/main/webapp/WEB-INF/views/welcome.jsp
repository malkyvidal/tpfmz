<%-- 
    Document   : welcome
    Created on : 11/03/2017, 17:16:32
    Author     : malky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"	%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>

        <title>Inicio</title>
    </head>
    <body>
        <div class="container" >
            
            <%@include file="menu.jsp" %>
            <div class="row">
                <div class="app jumbotron">
                    <h1>Sistema de Seguimiento de Alumnos</h1>
                </div>

            </div>
            
        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/");
                        
        
                });
                function activarMenu(menu){
                    
                    $("[href$='/tpfmz"+menu+"']").parent().addClass("active");
                }
            </script>
    </body>
</html>
