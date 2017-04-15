<%-- 
    Document   : updatePlan
    Created on : 09/04/2017, 18:45:38
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
        <title>Plan-Datos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">
                
                <form:form  modelAttribute="updatePlan"  class="form-horizontal">
                    <h2 align="center"> Modificar Datos de Plan </h2>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="nombre">Nombre</label>
                        
                        <form:input 	id="nombre"	path="nombre" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="nroResolucion">Resolución</label>
                        
                        <form:input	id="nroResolucion" path="nroResolucion" type="text" class="form:input-large"/>
                    </div>
                     <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="descripcion">Descripción</label>
                        
                        <form:input	id="descripcion" path="descripcion" type="text" class="form:input-large"/>
                    </div>    
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaIni">Fecha Inicio</label>
                        
                        <form:input	id="fechaIni" path="fechaIni" type="text" class="form:input-large"/>
                    </div>  
                       <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaFin">Fecha Finalización</label>
                        
                        <form:input	id="fechaFin" path="fechaFin" type="text" class="form:input-large"/>
                    </div> 
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/Planes");
                        
        
                });
               
            </script>
    </body>
</html>