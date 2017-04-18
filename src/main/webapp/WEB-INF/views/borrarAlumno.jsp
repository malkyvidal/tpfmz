<%-- 
    Document   : borrarAlumno
    Created on : Apr 15, 2017, 10:55:11 PM
    Author     : silvina
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

        <title>Eliminación de un Alumno</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            <div class="row">
                

               
                    <div class="col-md-4">
                        <h4>Todas las Materias-Alumnos que serán eliminadas</h4>
                    </div>
                       <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url value='/Alumnos/borrar/${legajo}'/>">eliminar</a>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>legAlumno</th>
                <th>codMateria</th>
                <th>estado</th>
                
            </tr>
            <c:forEach  items="${detalleMateriasAlumnos}" var="matAlum">
                <tr>
                                     
                       <td>${matAlum.alumno.legajo}</td>
                       <td>${matAlum.materia.codMateria}</td>
                       <td>${matAlum.estadoMateria}</td>
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
