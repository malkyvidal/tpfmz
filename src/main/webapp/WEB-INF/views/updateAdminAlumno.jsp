<%-- 
    Document   : updateAdminAlumno
    Created on : 12/04/2017, 19:45:57
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

                <form:form  modelAttribute="updateAdminAlumno"  class="form-horizontal">
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaAlta">Fecha Alta</label>
                        <td>${adminalumno.fechaAlta}</td>
                        <form:input 	id="fechaAlta"	path="fechaAlta" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="fechaBaja">Fecha Baja</label>
                        <td>${adminalumno.fechaBaja}</td>
                        <form:input 	id="fechaBaja"	path="fechaBaja" type="text" class="form:input-large"/>
                    </div>
                                                        
                   
                     <div class="form-group" >

                        <label class="control-label col-md-2" for="codPerfil">Perfil</label>                    
                        <form:select id="codPerfil" path="perfil.codPerfil">
                            <form:options items="${datosPerfiles}" itemLabel="descripcion" itemValue="codPerfil"></form:options>
                        </form:select>
                    </div>        
                   

                    
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
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

