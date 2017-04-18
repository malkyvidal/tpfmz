<%-- 
    Document   : nuevoAlumno
    Created on : 30-mar-2017, 20:31:05
    Author     : malky
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
        <title>Alumno-Datos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            
            
            <div class="row">

                <form:form  modelAttribute="nuevoAlumno"  class="form-horizontal">
                    <h2 align="center"> Agregar Nuevo Alumno </h2>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="email">Dirección de Correo Electrónico</label>

                        <form:input 	id="email"	path="email" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="telefono">Teléfono</label>
                        <form:input	id="telefono" path="telefono" type="text" class="form:input-large"/>
                    </div>


                    <div class="form-group" >
                        <label class="control-label col-md-2" for="contrasenia">Contraseña</label>
                        <form:input	id="contrasenia" path="contrasenia" type="password" class="form:input-large"/>

                    </div>

                   

                    <div class="form-group" >

                        <label class="control-label col-md-2" for="plan">Plan</label>
                        <form:select id="plan" path="plan.identificador">
                            <form:options items="${datosPlanes}" itemLabel="nombre" itemValue="identificador"></form:options>
                        </form:select>
                    </div>
   
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="codPerfil">Perfil</label>
                        <form:select id="codPerfil" path="perfil.codPerfil">
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
                       activarMenu("/Alumnos");
                        
        
                });
               
            </script>
    </body>
</html>
