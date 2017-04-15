<%-- 
    Document   : updateModulo
    Created on : Apr 8, 2017, 11:17:03 AM
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
        <title>Modulo-Datos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            
            
            <div class="row">

                <form:form  modelAttribute="updateModulo"  class="form-horizontal">
                      <div class="form-group" >
                        <label class="control-label col-md-2" for="permiso">Permiso</label>
                         
                        <form:select id="permiso" path="permiso.codPermiso">
                            <form:options items="${datosPermisos}" itemLabel="codPermiso" itemValue="codPermiso"></form:options>
                        </form:select>
                        
                    </div>
                        
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="descripcion">Descripción</label>
                        
                        <form:textarea 	id="descripcion"	path="descripcion" type="text" class="form:input-large"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                    </div>
                        
                         
                </form:form >
            </div>

        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/Modulos");
                        
        
                });
               
            </script>
    </body>
</html>
