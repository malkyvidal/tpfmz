<%-- 
    Document   : adminalumno
    Created on : 11/04/2017, 19:21:53
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

        <title>Administrador Alumnos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
                                        
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos Los Administradores</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/AdminAlumno/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>Legajo</th>
                <th>Fecha Alta</th>
                <th>Fecha Baja</th>
                <th>Código Perfil</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="admin">
                <tr>
                 
                    

                       <td>${admin.legajo}</td>
                       <td>${admin.fechaAlta}</td>
                       <td>${admin.fechaBaja}</td>
                       <td>${admin.perfil.codPerfil}</td>
                       <td>

                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/AdminAlumno/eliminar/${admin.legajo}'/>">Eliminar</a>
                           <a class="btn btn-success custom-width" href="<spring:url	value='/AdminAlumno/update/${admin.legajo}'/>">Editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                      <script>
                $(document).ready(function(){
                       activarMenu("/AdminAlumno");
                        
        
                });
               
            </script>
    </body>
</html>
