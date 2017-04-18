<%-- 
    Document   : updateCoordinador
    Created on : Apr 9, 2017, 10:24:09 PM
    Author     : silvina
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
        <title>Coordinador-Datos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
                 
                    
                  <form:form  modelAttribute="updateCoordinador"  class="form-horizontal">
                    <h2 align="center"> Modificar Datos Coordinador </h2>
                      <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="nroResolucion">nroResolución</label>
                        
                        <form:input 	id="nroResolucion"	path="nroResolucion"  class="form:input-large"/>
                    </div>
                    
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="especialidad">Especialidad</label>
                        
                        <form:input	id="especialidad" path="especialidad" type="text" class="form:input-large"/>
                    </div>
                      <div class="form-group" >

                        <label class="control-label col-md-2" for="plan">Plan</label>
                        
                        <form:select id="plan" path="plan.identificador">
                            <form:options items="${datosPlanes}" itemLabel="identificador" itemValue="identificador"></form:options>
                        </form:select>
                    </div>
                     <div class="form-group" >

                        <label class="control-label col-md-2" for="codPerfil">Perfil</label>
                        
                        <form:select id="codPerfil" path="perfil.codPerfil">
                            <form:options items="${datosPerfiles}" itemLabel="descripcion" itemValue="codPerfil"></form:options>
                        </form:select>
                    </div>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaAlta">Fecha Alta (dd-mm-aaaa)</label>
                        
                        <form:input	id="fechaAlta" path="fechaAlta"  class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaBaja">Fecha Baja (dd-mm-aaaa)</label>
                        
                        <form:input	id="fechaBaja" path="fechaBaja"  class="form:input-large"/>
                    </div>
                    
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="contrasenia">Constraseña</label>
                        <form:input	id="contrasenia" path="contrasenia" type="password" class="form:input-large"/>

                    </div>
                         
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/Coordinadores");
                        
        
                });
               
            </script>
    </body>
</html>