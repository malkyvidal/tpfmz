<%-- 
    Document   : borrarPerfil
    Created on : Apr 9, 2017, 2:34:06 PM
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

        <title>Eliminación de un Perfil</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
                                        
            <div class="row">
                

               
                    <div class="col-md-4">
                        <h4>Permisos a eliminar junto a sus Modulos asociados.</h4>
                    </div>
                       <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url value='/Perfiles/borrar/${codPerf}'/>">eliminar</a>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>codPermiso</th>
                <th>codPerfil</th>
                <th>acción</th>
                
            </tr>
            <c:forEach  items="${detallePermisos}" var="permiso">
                <tr>
                                     
                    <td>${permiso.codPermiso}</td>
                       <td>${permiso.perfil.codPerfil}</td>
                       <td>${permiso.accion}</td>
                        
       
                       </td>
                </tr>
            </c:forEach>
                
        </table>
                    
	    </div>
        </div>
                 <script>
                $(document).ready(function(){
                       activarMenu("/Perfiles");
                        
        
                });
               
            </script>
    </body>
</html>
