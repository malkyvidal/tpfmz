<%-- 
    Document   : borrarPermiso
    Created on : Apr 8, 2017, 6:42:50 PM
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

        <title>Eliminación de un Permiso</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            <div class="row">
                

               
                    <div class="col-md-4">
                        <h4>Todos Los Modulos que serán eliminados</h4>
                    </div>
                       <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url value='/Permisos/borrar/${codPermi}'/>">eliminar</a>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>codModulo</th>
                <th>codPermiso</th>
                <th>descripción</th>
                
            </tr>
            <c:forEach  items="${detalleModulos}" var="modulo">
                <tr>
                                     
                    <td>${modulo.codModulo}</td>
                       <td>${modulo.permiso.codPermiso}</td>
                       <td>${modulo.descripcion}</td>

                           
       
                       
                </tr>
            </c:forEach>
                
        </table>
                    
	    </div>
        </div>
                 <script>
                $(document).ready(function(){
                       activarMenu("/Permisos");
                        
        
                });
               
            </script>
    </body>
</html>

