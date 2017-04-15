<%-- 
    Document   : nuevoMensaje
    Created on : 14/04/2017, 18:43:41
    Author     : franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@	taglib	prefix="form"	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje -Datos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">

                <form:form  modelAttribute="nuevoMensaje"  class="form-horizontal">
                    
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="fecha">Fecha Mensaje</label>

                        <form:input 	id="fecha"	path="fecha" type="text" class="form:input-large"/>
                    </div>
                   
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="usuarioByUsuarioDestinatario">Destinatario</label>
                        <form:select id="usuarioByUsuarioDestinatario" path="usuarioByUsuarioDestinatario.legajo">
                            <form:options items="${destinatario}" itemLabel="legajo" itemValue="legajo"></form:options>
                        </form:select>
                    </div>     
                     <div class="form-group" >
                        <label class="control-label col-md-2" for="contenido">Contenido</label>

                        <form:input 	id="contenido"	path="contenido" type="text" class="form:input-large"/>
                    </div>

                    
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Crear"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            
            <script>
                $(document).ready(function(){
                       activarMenu("/Mensajes");
                        
        
                });
               
            </script>
    </body>
</html>

