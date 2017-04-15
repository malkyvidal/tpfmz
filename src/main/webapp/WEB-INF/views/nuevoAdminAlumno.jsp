<%-- 
    Document   : nuevoAdminAlumno
    Created on : 12/04/2017, 18:49:31
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
        <title>Admnistrador Alumnado -Datos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            
            <div class="row">

                <form:form  modelAttribute="nuevoAdminAlumno"  class="form-horizontal">
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="fechaAlta">Fecha Alta</label>

                        <form:input 	id="fechaAlta"	path="fechaAlta" type="text" class="form:input-large"/>
                    </div>
                   
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="contrasenia">Password</label>
                        <form:input	id="contrasenia" path="contrasenia" type="password" class="form:input-large"/>

                    </div>
                     <div class="form-group" >

                        <label class="control-label col-md-2" for="codPerfil">Perfil</label>
                        <form:select id="codPerfil" path="codPerfil">
                            <form:options items="${datosPerfiles}" itemLabel="descripcion" itemValue="codPerfil"></form:options>
                        </form:select>
                    </div>       
                   

                    
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Crear"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/AdminAlumno");
                        
        
                });
               
            </script>
    </body>
</html>

