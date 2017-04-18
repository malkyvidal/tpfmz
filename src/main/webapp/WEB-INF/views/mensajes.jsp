<%-- 
    Document   : mensajes
    Created on : 14/04/2017, 16:31:38
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Mensajes</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos los Mensajes</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Mensajes/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>Fecha</th>
                <th>Remitente</th>
                <th>Destinatario</th>
                <th>Mensaje</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="mensaje">
                <tr>
                 
                    
                       <td>${mensaje.fecha}</td>
                       <td>${mensaje.usuarioByUsuarioRemitente.legajo}</td>
                       <td>${mensaje.usuarioByUsuarioDestinatario.legajo}</td>
                       <td>${mensaje.contenido}</td>
                       <td>

                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Mensajes/eliminar/${mensaje.id}'/>">Eliminar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    <script>
                $(document).ready(function(){
                       activarMenu("/Coordinadores");
                        
        
                });
               
            </script>
    </body>
</html>
