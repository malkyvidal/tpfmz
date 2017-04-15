<%-- 
    Document   : perfiles
    Created on : Apr 5, 2017, 6:49:43 PM
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

        <title>Perfiles</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos Los Perfiles</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Perfiles/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>codPerfil</th>
                <th>descripcion</th>
                <th>estado</th>
                <th>Acción</th>
                
            </tr>
            <c:forEach  items="${datos}" var="perfil">
                <tr>                                   

                       <td>${perfil.codPerfil}</td>
                       <td>${perfil.descripcion}</td>
                       <td>${perfil.estado}</td>
                       <td>

                           <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Perfiles/eliminar/${perfil.codPerfil}'/>">eliminar</a>
                            <a class="btn btn-default" href="<spring:url	value='/Perfiles/update/${perfil.codPerfil}'/>">editar</a>
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
