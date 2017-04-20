<%-- 
    Document   : planes
    Created on : 05/04/2017, 17:56:45
    Author     : franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Planes Vigentes</title>
    </head>
<body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos los Planes</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Planes/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>Identificador</th>
                <th>Nombre</th>
                <th>Resolución</th>
                <th>Descripción</th>
                <th>Fecha de Inicio</th>
                <th>Fecha de Finalización</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${planes}" var="plan">
                <tr>
                       <td>${plan.identificador}</td>
                       <td>${plan.nombre}</td>
                       <td>${plan.nroResolucion}</td>
                       <td>${plan.descripcion}</td>
                       <td>${plan.fechaIni}</td>
                       <td>${plan.fechaFin}</td>
                       <td>

                          
                           <a class="btn btn-success custom-width" href="<spring:url	value='/Planes/update/${plan.identificador}'/>">Editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    
                    <script>
                $(document).ready(function(){
                       activarMenu("/Planes");
                        
        
                });
               
            </script>
    </body>
</html>