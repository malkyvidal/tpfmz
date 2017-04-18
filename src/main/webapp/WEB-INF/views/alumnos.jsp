<%-- 
    Document   : alumnos
    Created on : 28-mar-2017, 21:35:51
    Author     : malky
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

        <title>Alumnos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos los Alumnos</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Alumnos/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                <th>Legajo</th>
                <th>Teléfono</th>
                <th>Dirección de Correo Electrónico</th>
                <th>Plan</th>
                <th>Perfil</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="alumno">
                <tr>
                       
                    <td>${alumno.legajo}</td>   
                    <td>${alumno.telefono}</td>
                    <td>${alumno.email}</td>
                    <td>${alumno.plan.identificador}</td>
                    <td>${alumno.perfil.codPerfil}</td>
                       
                       <td>

                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Alumnos/eliminar/${alumno.legajo}'/>">Eliminar</a>
                           <a class="btn btn-success custom-width" href="<spring:url	value='/Alumnos/update/${alumno.legajo}'/>">Editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    
            <script>
                $(document).ready(function(){
                       activarMenu("/Alumnos");
                        
        
                });
               
            </script>
    </body>
</html>
