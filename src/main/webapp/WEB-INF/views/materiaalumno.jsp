<%-- 
    Document   : materiaalumno
    Created on : 09/04/2017, 19:17:31
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

        <title>Materias - Alumnos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos Las Materias - Alumnos</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/MateriaAlumno/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>Materia</th>
                <th>Alumno</th>
                <th>Estado</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="materiaalumno">
                <tr>
                 
                    

                       <td>${materiaalumno.materia.codMateria}</td>
                       <td>${materiaalumno.alumno.legajo}</td>
                       <td>${materiaalumno.estadoMateria}</td>
                       <td>

                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/MateriaAlumno/eliminar/${materiaalumno.id}'/>">Eliminar</a>
                           <a class="btn btn-success custom-width" href="<spring:url	value='/MateriaAlumno/update/${materiaalumno.id}'/>">Editar</a>
                        </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    <script>
                $(document).ready(function(){
                       activarMenu("/MateriaAlumno");
                        
        
                });
               
            </script>
    </body>
</html>
